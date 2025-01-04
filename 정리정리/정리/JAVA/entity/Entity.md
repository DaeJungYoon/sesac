# Entity
- 소프트웨어 개발에서 **데이터를 나타내는 핵심 개념**으로, 특히 **데이터베이스**와 객체지향 프로그래밍을 연계하는 데 사용됩니다. 주로 **JPA**(Java Persistence API)와 같은 ORM(Object Relational Mapping) 프레임워크에서 사용됩니다.

---
## Entity란?

1. **데이터베이스 관점**
    - **Entity**는 **데이터베이스 테이블(Table)** 에 매핑되는 객체입니다.
    - 테이블의 행(Row)이 객체의 인스턴스에 대응됩니다.
    - 테이블의 열(Column)은 객체의 필드(Field)에 대응됩니다.
2. **객체지향 프로그래밍 관점**
    - Entity는 고유한 식별자를 가지며, 상태(State)와 행동(Behavior)을 나타냅니다.
    - 데이터와 그 데이터를 조작하는 로직을 하나의 객체로 묶습니다.

---

## JPA에서 Entity

JPA에서 Entity는 다음과 같은 특징을 가집니다:
1. **클래스를 데이터베이스 테이블과 매핑**
    - JPA는 `@Entity` 어노테이션으로 클래스가 엔티티임을 선언합니다.
2. **엔티티의 각 필드는 데이터베이스 열과 매핑**
    - 필드는 기본적으로 열로 매핑되며, `@Column` 어노테이션으로 매핑 세부 사항을 설정할 수 있습니다.
3. **기본 키가 필요**
    - 엔티티는 데이터베이스에서 고유하게 식별될 수 있도록 하나 이상의 기본 키(Primary Key)가 필요합니다. 이를 위해 `@Id`와 `@GeneratedValue`를 사용합니다.

---
## Entity의 주요 어노테이션

### 1. `@Entity`
- 해당 클래스가 엔티티임을 선언.
- 기본적으로 클래스 이름이 데이터베이스 테이블 이름으로 사용됩니다.
```java
import jakarta.persistence.Entity;

@Entity
public class User {
    // 필드와 메서드
}
```
---

### 2. `@Table`

- 테이블 이름이나 스키마를 명시적으로 지정.
```java
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // 테이블 이름을 "users"로 설정
public class User {
    // 필드와 메서드
}
```

---
### 3. `@Id`와 `@GeneratedValue`
- `@Id`: 기본 키를 지정.
- `@GeneratedValue`: 기본 키 값의 생성 전략을 지정.
```java
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 사용
    private Long id;

    private String name;
}
```
---
### 4. `@Column`
- 특정 필드의 열 이름이나 속성을 명시적으로 설정.
```java
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    private int age;
}
```
- **속성**
    - `name`: 열 이름 설정.
    - `nullable`: null 허용 여부.
    - `length`: 문자열 길이 제한.
    - `unique`: 고유 제약 조건 설정.

---
### 5. `@Embedded`와 `@Embeddable`
- **내장된 객체**를 매핑.
```java
import jakarta.persistence.*;

@Embeddable
public class Address {
    private String city;
    private String street;
}

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;
}
```
---
### 6. 연관 관계 매핑

- 엔티티 간 관계를 매핑하기 위해 JPA는 다음 어노테이션을 제공합니다:
    - `@OneToOne`
    - `@OneToMany`
    - `@ManyToOne`
    - `@ManyToMany`

#### 예제: `@OneToMany`와 `@ManyToOne`
```java
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

