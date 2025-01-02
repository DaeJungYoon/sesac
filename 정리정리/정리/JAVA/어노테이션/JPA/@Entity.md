# @Entity
- Java Persistence API(JPA)에서 **클래스를 데이터베이스 테이블에 매핑**하기 위해 사용하는 어노테이션입니다. 
- 어노테이션이 선언된 클래스는 JPA가 관리하는 **엔티티(Entity)** 로 취급됩니다.

### 주요 특징

1. **클래스와 데이터베이스 테이블의 매핑**
    - JPA는 `@Entity`가 선언된 클래스를 기준으로 데이터베이스 테이블을 생성하거나 해당 테이블과 연동합니다.
    - 엔티티 클래스의 각 필드는 데이터베이스 테이블의 **컬럼**으로 매핑됩니다.
2. **기본 요구 사항**
    - `@Entity`가 선언된 클래스는 **기본 생성자**(no-args constructor)가 있어야 합니다.
    - 클래스에는 **식별자 필드(@Id)**가 반드시 필요합니다.
3. **데이터베이스 테이블 이름 지정 (옵션)**
    - 기본적으로 클래스 이름이 데이터베이스 테이블 이름으로 사용됩니다.
    - `@Table` 어노테이션을 추가하여 테이블 이름을 지정할 수 있습니다.

---

### 사용 예시
#### 1. 기본 `@Entity` 클래스
``` java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id; // Primary Key
    
    private String name;
    private String email;
}
```
#### 2. 테이블 이름 지정 (`@Table`)
```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // 테이블 이름을 "users"로 지정
public class User {
    @Id
    private Long id;
    
    private String name;
    private String email;
}

```
#### 3. 식별자와 자동 생성 전략 (`@GeneratedValue`)
```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 값 사용
    private Long id;
    
    private String name;
    private String email;
}
```
---
### 주요 어노테이션과의 관계
- **`@Id`**: 엔티티의 기본 키(Primary Key)를 지정합니다. `@Entity`가 적용된 클래스에는 반드시 포함되어야 합니다.
- **`@GeneratedValue`**: 기본 키 값을 자동으로 생성하는 방식을 정의합니다.
- **`@Table`**: 엔티티와 매핑할 테이블 이름 및 속성을 설정합니다.
- **`@Column`**: 클래스 필드를 데이터베이스의 특정 열과 매핑하며, 열 이름이나 제약 조건을 설정할 수 있습니다.
---
### 주의할 점
1. **기본 생성자 필수**
    - JPA가 엔티티를 관리할 때 기본 생성자를 사용합니다.
    - 보통 `protected` 접근자로 선언하는 것이 일반적입니다.
``` java

@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok으로 생성자 자동 생성
```
2. **직렬화 가능성**
- 엔티티 클래스는 가급적 **Serializable** 인터페이스를 구현하도록 권장됩니다.
---
### 정리
`@Entity`는 JPA에서 클래스와 데이터베이스 간의 매핑을 설정하는 핵심 어노테이션입니다. 이를 통해 객체 지향 프로그래밍 방식으로 데이터베이스 작업을 수행할 수 있으며, SQL을 직접 작성하지 않고도 데이터를 효율적으로 다룰 수 있습니다.