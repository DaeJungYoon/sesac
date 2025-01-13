Java의 JPA(Java Persistence API)에서 **케스케이드(Cascade)**는 엔티티 간 연관 관계에서 **부모 엔티티의 작업(저장, 삭제 등)을 자식 엔티티에 자동으로 전파**하는 기능입니다.  
부모와 자식 간의 관계를 정의할 때, **데이터 조작(persist, remove 등)**이 자동으로 연계되도록 설정하는 옵션입니다.

---

### **케스케이드의 필요성**

엔티티 간 관계를 명시적으로 설정할 경우, 부모와 자식 엔티티 각각에 대해 데이터베이스 작업을 수행해야 합니다.  
예를 들어, 부모 엔티티를 저장하려면 자식 엔티티도 개별적으로 저장해야 하지만, **케스케이드를 설정하면 부모 작업만으로 자식 작업이 자동으로 처리**됩니다.

---

### **케스케이드 유형**

JPA는 다양한 케스케이드 옵션을 제공합니다. 이를 `CascadeType`으로 설정합니다.

1. **`CascadeType.PERSIST`**
    
    - 부모 엔티티를 저장할 때 자식 엔티티도 함께 저장됩니다.
    - 예: `entityManager.persist(parent)` → 부모와 자식 모두 저장.
2. **`CascadeType.MERGE`**
    
    - 부모 엔티티를 병합(업데이트)할 때 자식 엔티티도 함께 병합됩니다.
    - 예: `entityManager.merge(parent)` → 부모와 자식 모두 업데이트.
3. **`CascadeType.REMOVE`**
    
    - 부모 엔티티를 삭제할 때 자식 엔티티도 함께 삭제됩니다.
    - 예: `entityManager.remove(parent)` → 부모와 자식 모두 삭제.
4. **`CascadeType.REFRESH`**
    
    - 부모 엔티티를 새로 고침(refresh)하면 자식 엔티티도 데이터베이스 값으로 동기화됩니다.
    - 예: `entityManager.refresh(parent)` → 부모와 자식 모두 동기화.
5. **`CascadeType.DETACH`**
    
    - 부모 엔티티를 영속성 컨텍스트에서 분리(detach)하면 자식 엔티티도 함께 분리됩니다.
    - 예: `entityManager.detach(parent)` → 부모와 자식 모두 비영속 상태로 전환.
6. **`CascadeType.ALL`**
    
    - 위 모든 옵션(PERSIST, MERGE, REMOVE, REFRESH, DETACH)을 포함합니다.

---

### **케스케이드 예제**

#### **1. 엔티티 관계 설정**
```java
@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children = new ArrayList<>();
}

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}

```

---

#### **2. 케스케이드 사용 코드**
```java
// 부모 엔티티 생성
Parent parent = new Parent();
parent.setName("부모 엔티티");

// 자식 엔티티 생성
Child child1 = new Child();
child1.setName("자식 1");

Child child2 = new Child();
child2.setName("자식 2");

// 관계 설정
child1.setParent(parent);
child2.setParent(parent);
parent.getChildren().add(child1);
parent.getChildren().add(child2);

// 부모를 저장하면 자식도 자동으로 저장 (CascadeType.PERSIST)
entityManager.persist(parent);

// 부모를 삭제하면 자식도 자동으로 삭제 (CascadeType.REMOVE)
entityManager.remove(parent);
```

---
### **장점**

1. **코드 단순화**  
    부모와 자식 엔티티를 개별적으로 저장하거나 삭제할 필요 없이 한 번의 작업으로 처리 가능.
    
2. **데이터 일관성 유지**  
    부모와 자식 간 관계가 유지되도록 자동으로 처리.
    

---

### **주의 사항**

1. **성능 문제**  
    대량의 자식 엔티티가 있는 경우, 케스케이드로 인해 한 번에 대규모 데이터 작업이 수행될 수 있음.
    
2. **`orphanRemoval` 옵션 사용 시 주의**  
    `orphanRemoval = true`를 설정하면 부모 엔티티에서 제거된 자식 엔티티는 데이터베이스에서도 자동으로 삭제됩니다.
    
    - 예: 부모의 `children` 리스트에서 자식 엔티티를 제거하면 DB에서 삭제됩니다.
    
```java
parent.getChildren().remove(child1); // DB에서도 child1 삭제
```

1. **모든 경우에 `CascadeType.ALL` 사용 지양**  
    불필요한 데이터 작업을 방지하려면 필요한 작업만 명시적으로 설정하는 것이 좋습니다.
    

---

### **케스케이드와 `orphanRemoval`의 차이**

|**옵션**|**기능**|
|---|---|
|**CascadeType.REMOVE**|부모 엔티티가 삭제될 때, 자식 엔티티도 함께 삭제됩니다.|
|**orphanRemoval=true**|부모-자식 관계에서 부모 엔티티가 자식 엔티티를 참조하지 않으면(리스트에서 제거 등) 자식 엔티티를 삭제합니다.|

---

케스케이드는 엔티티 간 관계를 관리하는 데 매우 유용한 도구입니다. 하지만 성능과 데이터 무결성을 항상 염두에 두고 신중히 설정해야 합니다.