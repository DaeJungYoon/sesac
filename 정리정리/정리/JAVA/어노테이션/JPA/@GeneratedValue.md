# @GeneratedValue
- **JPA(Java Persistence API)** 에서 엔티티 클래스의 기본 키 값이 **자동으로 생성** 되도록 설정할 때 사용하는 어노테이션입니다.

---
### 주요 역할
- **기본 키 생성 전략**을 정의합니다.
- 데이터베이스에서 기본 키 값을 어떻게 생성할지 결정합니다.
- `@Id`와 함께 사용하여 기본 키 필드에 값을 자동으로 할당합니다.
---
### 사용법
```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략
    private Long id;

    private String name;
}
```
---
### 속성: `strategy`
`@GeneratedValue`의 `strategy` 속성은 기본 키를 생성하는 방식을 설정합니다. **4가지 옵션**이 있습니다.
#### 1. **`GenerationType.IDENTITY`**
- 데이터베이스의 **자동 증가 컬럼(AUTO_INCREMENT)** 기능을 사용.
- JPA가 데이터베이스에 기본 키 생성을 위임합니다.
- MySQL, MariaDB와 같은 데이터베이스에서 사용.
- 데이터베이스의 **AUTO_INCREMENT** 속성을 사용하여 기본 키 값이 자동으로 증가합니다.
예:
```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```
- 데이터베이스 테이블 생성 예:
```sql
CREATE TABLE ExampleEntity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
```
---
#### 2. **`GenerationType.SEQUENCE`**
- 데이터베이스의 **시퀀스 객체**를 사용하여 기본 키 생성.
- 시퀀스를 지원하는 데이터베이스(PostgreSQL, Oracle 등)에서 사용.
- JPA는 기본적으로 **hibernate_sequence**라는 시퀀스를 생성하여 사용합니다.
예:
```java
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
```
- 데이터베이스에서 시퀀스 생성 예:
```sql
CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;
```
- 특정 시퀀스를 사용하려면 `@SequenceGenerator`와 함께 사용:
```java
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
@SequenceGenerator(name = "seq_gen", sequenceName = "example_sequence", allocationSize = 1)
private Long id;
```
---
#### 3. **`GenerationType.TABLE`**
- 별도의 테이블을 생성하여 기본 키 값을 관리.
- 기본 키 생성 정보를 저장하는 테이블을 만들어 사용합니다.
- 이 방식은 성능이 떨어질 수 있으므로 잘 사용되지 않습니다.
예:
```java
@GeneratedValue(strategy = GenerationType.TABLE)
private Long id;
```
- 기본 키 테이블 생성 예:
```sql
CREATE TABLE hibernate_sequences (
    sequence_name VARCHAR(255) NOT NULL,
    next_val BIGINT,
    PRIMARY KEY (sequence_name)
);
```
---
#### 4. **`GenerationType.AUTO`**
- JPA가 데이터베이스에 맞는 전략을 자동으로 선택합니다.
- 예를 들어, MySQL에서는 `IDENTITY`, PostgreSQL에서는 `SEQUENCE`를 선택합니다.
예:
```java
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
```
---
### 언제 어떤 전략을 선택해야 할까?
1. **`GenerationType.IDENTITY`**
    - 간단한 자동 증가를 원할 때.
    - MySQL, MariaDB 등에서 가장 흔히 사용.
2. **`GenerationType.SEQUENCE`**
    - 시퀀스를 지원하는 데이터베이스에서 사용.
    - 고성능 및 병렬 작업이 필요한 경우 적합.
3. **`GenerationType.TABLE`**
    - 시퀀스를 지원하지 않는 데이터베이스에서 사용 가능하지만 성능이 낮음.
    - 권장되지 않음.
4. **`GenerationType.AUTO`**
    - 데이터베이스에 맞게 JPA가 자동으로 선택하도록 맡김.
    - 초기 개발 단계나 특정 전략에 의존하지 않을 때 사용.

---
### 예제 코드
```java
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 AUTO_INCREMENT 사용
    private Long id;

    private String title;
    private String content;
}
```
### 데이터 삽입 예시
```java
Post post = new Post();
post.setTitle("Hello World");
post.setContent("This is a test post.");
entityManager.persist(post);
```
#### 실행 결과 (SQL):
```sql
INSERT INTO Post (title, content) VALUES ('Hello World', 'This is a test post.');
-- 기본 키는 자동으로 생성됨.
```
---
### 요약
- `@GeneratedValue`는 JPA에서 엔티티의 기본 키를 자동 생성하는 방법을 지정하는 어노테이션입니다.
- `GenerationType` 옵션에 따라 데이터베이스의 AUTO_INCREMENT, SEQUENCE, TABLE 등을 사용할 수 있습니다.
- 데이터베이스와 요구사항에 맞는 전략을 선택하여 효율적인 키 생성 방식을 설정하세요.