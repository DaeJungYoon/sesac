# @Column
- `@Column`은 **JPA(Java Persistence API)**에서 엔티티 클래스의 필드를 데이터베이스 테이블의 컬럼에 매핑하기 위해 사용하는 어노테이션입니다.
---
### 주요 기능

1. **테이블 컬럼과 필드 매핑**
    - 엔티티 클래스의 필드가 데이터베이스 테이블의 특정 컬럼에 매핑되도록 지정합니다.
    - 이름, 데이터 타입, 길이, nullable 여부 등 컬럼의 세부 정보를 설정할 수 있습니다.

### 사용법
```java
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = true)
    private Integer age;

    // Getters and Setters
}
```
### 속성 설명

`@Column`은 여러 속성을 제공하며, 가장 자주 사용되는 속성은 다음과 같습니다:

1. **`name`**
    - 매핑할 데이터베이스 컬럼 이름을 지정합니다. 지정하지 않으면 필드 이름이 컬럼 이름으로 사용됩니다.
    - 예: `@Column(name = "username")`
2. **`nullable`**
    - 컬럼에 `NULL` 값을 허용할지 여부를 지정합니다.
    - 기본값: `true`
    - 예: `@Column(nullable = false)`
3. **`unique`**
    - 컬럼 값이 고유해야 하는지 여부를 지정합니다.
    - 기본값: `false`
    - 예: `@Column(unique = true)`
4. **`length`**
    - `VARCHAR` 타입 컬럼의 최대 길이를 지정합니다.
    - 기본값: 255
    - 예: `@Column(length = 50)`
5. **`precision`과 `scale`**
    - `BigDecimal` 타입에 사용되며, `precision`은 소수점을 포함한 전체 자릿수를, `scale`은 소수점 이하 자릿수를 지정합니다.
    - 예: `@Column(precision = 10, scale = 2)`
6. **`insertable`과 `updatable`**
    - 컬럼이 INSERT/UPDATE 시 값 변경 가능 여부를 지정합니다.
    - 기본값: `true`
    - 예: `@Column(insertable = false, updatable = false)`
7. **`columnDefinition`**
    - DDL 생성 시 사용할 컬럼 정의를 직접 지정합니다.
    - 예: `@Column(columnDefinition = "TEXT")`
8. **`table`**
    - 컬럼이 매핑될 테이블을 지정합니다. 다중 테이블 매핑 시 사용됩니다.
    - 예: `@Column(table = "secondary_table")`
---
### 동작 원리

- `@Column` 어노테이션은 JPA가 필드를 데이터베이스의 테이블 컬럼에 매핑할 때 필요한 정보를 제공합니다.
- 만약 `@Column`을 생략하면 JPA는 기본적으로 필드 이름을 컬럼 이름으로 사용합니다.

### 예시 설명
```java
@Column(name = "username", nullable = false, length = 50)
private String name;
```

- **`name = "username"`**: 데이터베이스 컬럼 이름을 `username`으로 지정.
- **`nullable = false`**: 컬럼 값이 반드시 있어야 함 (`NOT NULL`).
- **`length = 50`**: 최대 길이가 50인 `VARCHAR` 컬럼.
---
### 사용 이유
- 데이터베이스와의 매핑을 정확히 명시하기 위해.
- 제약 조건이나 데이터 타입을 설정해 데이터 무결성을 유지하기 위해.
- 유지보수성과 코드 가독성을 높이기 위해.

1. **명시적 매핑**
    
    - 엔티티 필드와 데이터베이스 컬럼 이름이 다를 경우, 이를 매핑하기 위해 사용합니다.
    - 예: `@Column(name = "user_name")` → 필드 `userName`을 컬럼 `user_name`에 매핑.
2. **제약 조건 설정**
    
    - NULL 허용 여부, 고유성, 길이 등 데이터베이스 레벨에서 제약 조건을 정의할 수 있습니다.
    - 예: `@Column(nullable = false, unique = true)`.
3. **데이터 타입 제어**
    
    - 컬럼의 데이터 타입을 세부적으로 정의할 수 있습니다.
    - 예: `@Column(columnDefinition = "TEXT")`.
4. **가독성 향상 및 유지보수**
    
    - 매핑 설정을 명시적으로 작성하면 코드의 의도를 명확히 하고, 변경이나 유지보수 시 편리합니다.
5. **DDL 생성 제어**
    
    - JPA가 스키마를 생성하거나 변경할 때 컬럼의 세부 설정을 반영하도록 도와줍니다.
---
### 참고

`@Column`은 선택적으로 사용되며, 기본값으로도 많은 경우 충분합니다. 특정 제약 조건이나 컬럼 이름을 다르게 설정해야 할 때 사용합니다.

### 요약
JPA에서 엔티티 클래스의 필드를 데이터베이스 테이블의 컬럼과 매핑할 때 사용되는 어노테이션입니다. 컬럼의 이름, 길이, NULL 허용 여부, 고유성 등 세부 설정을 지정할 수 있습니다.

만약 특별한 설정 없이 기본 매핑만 필요하면 생략할 수 있으며, JPA는 필드 이름을 컬럼 이름으로 자동 매핑합니다.