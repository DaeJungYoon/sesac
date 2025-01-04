# EntityManager
- `EntityManager`는 Java Persistence API(JPA)에서 **영속성 컨텍스트**(Persistence Context)를 관리하고 데이터베이스 작업을 수행하는 핵심 인터페이스입니다. 
- 애플리케이션에서 엔티티(Entity)를 생성, 조회, 업데이트, 삭제하는 작업을 추상화하여 제공하며, 데이터베이스와의 상호작용을 보다 고수준에서 처리할 수 있도록 도와줍니다.

---

### 주요 역할

1. **영속성 컨텍스트 관리**:
    - 영속성 컨텍스트는 엔티티의 상태를 관리하는 메모리 공간입니다.
    - `EntityManager`는 영속성 컨텍스트에 엔티티를 추가하거나 제거하며, 데이터베이스와의 동기화를 처리합니다.
2. **엔티티 라이프사이클 관리**:
    - 엔티티의 상태(비영속, 영속, 준영속, 삭제 상태)를 관리합니다.
3. **쿼리 실행**:
    - JPQL(Java Persistence Query Language) 및 네이티브 SQL을 실행하여 데이터베이스와 상호작용합니다.
4. **트랜잭션 관리**:
    - 데이터베이스 작업을 트랜잭션 범위 내에서 처리합니다.

---

### 주요 메서드

#### 1. 엔티티 저장 및 갱신
- `persist(Object entity)`: 엔티티를 영속성 컨텍스트에 저장.
- `merge(Object entity)`: 준영속 상태의 엔티티를 영속성 컨텍스트로 병합.

#### 2. 엔티티 조회
- `find(Class<T> entityClass, Object primaryKey)`: 엔티티를 기본 키로 조회.
- `getReference(Class<T> entityClass, Object primaryKey)`: 프록시를 반환(지연 로딩).

#### 3. 엔티티 삭제
- `remove(Object entity)`: 영속성 컨텍스트에서 엔티티를 제거.

#### 4. 쿼리 실행
- `createQuery(String qlString)`: JPQL 쿼리 생성.
- `createNativeQuery(String sqlString)`: 네이티브 SQL 쿼리 생성.

#### 5. 트랜잭션 관리
- `getTransaction()`: 트랜잭션 객체를 반환.
- `flush()`: 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화.
- `clear()`: 영속성 컨텍스트 초기화.
- `close()`: `EntityManager`를 종료.

---

### EntityManager 사용 예제

#### 기본 사용
```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); // 트랜잭션 시작

        // 엔티티 생성 및 저장
        User user = new User();
        user.setName("Alice");
        em.persist(user);

        em.getTransaction().commit(); // 트랜잭션 커밋

        em.close();
        emf.close();
    }
}
```
---
### EntityManager의 주요 동작

#### 1. **영속성 컨텍스트**
- `EntityManager`는 영속성 컨텍스트를 통해 엔티티 상태를 관리합니다.
- 영속성 컨텍스트에 있는 엔티티는 데이터베이스와 동기화되며, 자동 변경 감지(Dirty Checking)가 가능합니다.

#### 2. **엔티티 상태**
- **비영속(Transient)**: 영속성 컨텍스트에 관리되지 않는 상태.
- **영속(Persistent)**: 영속성 컨텍스트에 의해 관리되는 상태.
- **준영속(Detached)**: 영속성 컨텍스트에서 분리된 상태.
- **삭제(Removed)**: 삭제 대기 상태.

#### 3. **트랜잭션**
- 대부분의 `EntityManager` 작업은 트랜잭션 범위 내에서 실행됩니다.
- 예: `persist`, `merge`, `remove`는 트랜잭션이 필요합니다.

---

### EntityManager와 Spring Data JPA

Spring Data JPA에서는 `EntityManager`를 직접 사용할 일이 많지 않습니다. 대신, Spring이 제공하는 `JpaRepository`와 같은 추상화된 인터페이스를 활용합니다. 하지만 복잡한 쿼리나 커스텀 로직이 필요할 경우 `EntityManager`를 직접 주입받아 사용할 수 있습니다.

#### 사용 예제
```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public User findByName(String name) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class)
                            .setParameter("name", name)
                            .getSingleResult();
    }
}
```
---
### 장점
1. 고수준 API를 통해 데이터베이스 작업 간소화.
2. 영속성 컨텍스트를 활용한 효율적인 캐싱 및 변경 감지.
3. JPA의 표준 인터페이스로 다양한 구현체와 호환 가능.

### 단점
1. 사용법이 복잡할 수 있음(특히 트랜잭션 관리와 영속성 컨텍스트의 이해 필요).
2. 특정 상황에서는 성능 이슈가 발생할 수 있음(지연 로딩, 캐싱 등).

---

`EntityManager`는 JPA의 핵심 구성요소로, 데이터베이스와 객체 간의 상호작용을 효율적으로 처리하는 데 필수적입니다. 하지만 Spring Data JPA와 같은 추상화 레이어를 사용하면 더 간단하게 작업할 수 있습니다. 😊