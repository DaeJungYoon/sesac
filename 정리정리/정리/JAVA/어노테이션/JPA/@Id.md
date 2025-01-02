# @Id
- **Java Persistence API (JPA)** 에서 사용하는 어노테이션으로, **엔티티 클래스의 필드를 데이터베이스 테이블의 기본 키(Primary Key)** 로 지정합니다.
- JPA를 사용하는 모든 엔티티 클래스에는 반드시 `@Id`로 지정된 **기본 키 필드**가 있어야 합니다. 이 필드를 통해 엔티티를 고유하게 식별할 수 있습니다.
---
### 주요 특징
1. **기본 키 필드 지정**
    - `@Id`를 통해 해당 필드를 기본 키로 지정합니다.
    - 기본 키는 데이터베이스에서 각 레코드를 고유하게 식별합니다.
2. **생성 전략 설정 (Optional)**
    - `@GeneratedValue`와 함께 사용하여 기본 키의 값이 자동으로 생성되도록 설정할 수 있습니다.

---
### 사용 예시
#### 1. 기본 키 필드 정의
```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id; // 기본 키
    private String name;
}
```
#### 2. 자동 생성 전략과 함께 사용 (`@GeneratedValue`)
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
}
``` 
---
### `@Id`와 함께 사용하는 어노테이션: `@GeneratedValue`
`@GeneratedValue`는 기본 키 값의 **자동 생성 전략**을 정의합니다. 주요 옵션은 다음과 같습니다:
1. **`GenerationType.IDENTITY`**
    - 데이터베이스에 기본 키 생성을 위임합니다.
    - 보통 MySQL의 **AUTO_INCREMENT**와 같은 기능과 연동됩니다.
```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```
2. **`GenerationType.SEQUENCE`**
- 데이터베이스의 **시퀀스 객체**를 사용합니다. (PostgreSQL 등)
- 특정 시퀀스를 지정하려면 `@SequenceGenerator`를 사용합니다.
```java
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
private Long id;
```
3.  **`GenerationType.TABLE`**
    - 별도의 테이블을 사용하여 기본 키를 생성합니다.
    - 잘 사용되지 않는 전략입니다.
4. **`GenerationType.AUTO`**   
    - JPA가 데이터베이스에 맞는 전략을 자동으로 선택합니다.
---
### 왜 `@Id`가 필요한가?
1. **엔티티의 유일성 보장**
    - 데이터베이스에서 각 레코드를 고유하게 식별하기 위해 기본 키가 필요합니다.
2. **JPA의 엔티티 관리**
    - JPA는 `@Id`로 지정된 필드를 기준으로 엔티티를 식별하고 관리합니다.
    - 예를 들어, 엔티티를 데이터베이스에서 조회하거나 삭제할 때 기본 키를 사용합니다.
3. **관계 설정**
    - 엔티티 간의 연관 관계를 설정할 때도 기본 키가 필요합니다.
    - 예: `@OneToMany`, `@ManyToOne` 관계에서 기본 키를 활용합니다.

---
### 예제: 엔티티와 기본 키
```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 기본 키
    private Long id;

    private String title;
    private String content;

    // Getter, Setter, Constructor
}
```
### 데이터베이스 테이블 생성
위 코드를 기준으로 JPA는 다음과 같은 테이블을 생성합니다
```sql
CREATE TABLE Post (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    content VARCHAR(255)
);
```
---
### 정리
- `@Id`는 JPA에서 엔티티의 기본 키를 정의하는 데 필수적인 어노테이션입니다.
- 기본 키 값은 수동으로 설정하거나, `@GeneratedValue`를 사용해 자동으로 생성할 수 있습니다.
- JPA는 `@Id`로 지정된 필드를 기준으로 데이터베이스와의 상호작용을 처리하므로, 모든 엔티티 클래스에는 `@Id`가 반드시 필요합니다.