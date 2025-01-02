# [Spring Data JPA에서 새로운 Entity인지 판단하는 방법은 무엇일까요?](https://www.maeil-mail.kr/question/27)

백엔드와 관련된 질문이에요.

```java
@Override
public boolean isNew(T entity) {

    if(versionAttribute.isEmpty()) 
          || versionAttribute.map(Attribute::getJavaType)
          .map(Class::isPrimitive).orElse(false)) {
        return super.isNew(entity);
    }

    BeanWrapper wrapper = new DirectFieldAccessFallbackBeanWrapper(entity);

    return versionAttribute.map(it -> wrapper
    .getPropertyValue(it.getName()) == null).orElse(true);
}

```

새로운 Entity인지 여부는 JpaEntityInformation의 `isNew(T entity)`에 의해 판단됩니다. 다른 설정이 없으면 JpaEntityInformation의 구현체 중 JpaMetamodelEntityInformation 클래스가 동작합니다. `@Version`이 사용된 필드가 없거나 `@Version`이 사용된 필드가 primitive 타입이면 AbstractEntityInformation의 `isNew()`를 호출합니다. `@Version`이 사용된 필드가 wrapper class이면 null여부를 확인합니다.

```java
public boolean isNew(T entity) {

    Id id = getId(entity);
    Class<ID> idType = getIdType();

    if (!idType.isPrimitive()) {
        return id == null;
    }

    if (id instanceof Number) {
        return ((Number) id).longValue() == 0L;
    }

    throw new IllegalArgumentException
    (String.format("Unsupported primitive id type %s", idType));
}
```

`@Version`이 사용된 필드가 없어서 AbstractEntityInformation 클래스가 동작하면 `@Id` 어노테이션을 사용한 필드를 확인해서 primitive 타입이 아니라면 null 여부, Number의 하위 타입이면 0인지 여부를 확인합니다.`@GeneratedValue` 어노테이션으로 키 생성 전략을 사용하면 데이터베이스에 저장될 때 id가 할당됩니다. 따라서 데이터베이스에 저장되기 전에 메모리에서 생성된 객체는 id가 비어있기 때문에 `isNew()`는 true가 되어 새로운 entity로 판단합니다.

## 직접 ID를 할당하는 경우에는 어떻게 동작하나요? 🤔

키 생성 전략을 사용하지 않고 직접 ID를 할당하는 경우 새로운 entity로 간주되지 않습니다. 이 때는 엔티티에서 `Persistable<T>` 인터페이스를 구현해서 JpaMetamodelEntityInformation 클래스가 아닌 JpaPersistableEntityInformation의 `isNew()`가 동작하도록 해야 합니다.

```java
public class JpaPersistableEntityInformation<T extends Persistable<ID, ID> 
        extends JpaMetamodelEntityInformation<T, ID> {

    public JpaPersistableEntityInformation
    (Class<T> domainClass, Metamodel metamodel, 
            PersistenceUnitUtil persistenceUnitUtil) {
        super(domainClass, metamodel, persistenceUnitUtil);
    }

    @Override
    public boolean isNew(T entity) {
        return entity.isNew();
    }

    @Nullable
    @Override
    public ID getId(T entity) {
        return entity.getId();
    }
}
```

## 새로운 Entity인지 판단하는게 왜 중요할까요? 🤓

```java
@Override
@Transactional
public <S extends T> S save(S entity) {

    Assert.notNull(entity, "Entity must not be null");

	if (entityInformation.isNew(entity)) {
		entityManager.persist(entity);
		return entity;
	} else {
		return entityManager.merge(entity);
	}
}
```

SimpleJpaRepository의 `save()` 메서드에서 `isNew()`를 사용하여 persist를 수행할지 merge를 수행할지 결정합니다. 만약 ID를 직접 지정해주는 경우에는 신규 entity라고 판단하지 않기 때문에 merge를 수행합니다. 이때 해당 entity는 신규임에도 불구하고 DB를 조회하기 때문에 비효율적입니다. 따라서, 새로운 entity인지 판단하는 것은 중요한 부분입니다.

## 추가 학습 자료를 공유합니다.

- [save()시 식별자가 존재하는 경우 어떻게 동작할까?](https://ttl-blog.tistory.com/807)
- [Persistable - 새로운 엔티티 판별 여부 설정](https://ttl-blog.tistory.com/852)
- [save메서드로 살펴보는 persist와 merge 개념](https://umanking.github.io/2019/04/12/jpa-persist-merge/) 
