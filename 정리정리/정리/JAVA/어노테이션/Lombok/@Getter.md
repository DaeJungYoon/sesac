# @Getter
- **Lombok**에서 제공하는 어노테이션으로, 클래스의 **모든 필드에 대해 getter 메서드**를 자동으로 생성합니다.  
- 이를 통해 반복적으로 작성해야 하는 코드를 줄이고, 코드의 간결성과 가독성을 높일 수 있습니다.
### 기본 사용법
#### 1. 클래스 수준에서 사용
```java
import lombok.Getter;

@Getter
public class Example {
    private String name;
    private int age;
}
```
위 코드는 다음과 같은 getter 메서드를 자동으로 생성합니다
``` java
public String getName() {
    return name;
}

public int getAge() {
    return age;
}
```
#### 2. 필드 수준에서 사용
특정 필드에만 getter를 생성하려면, 해당 필드에 직접 추가합니다
```java
import lombok.Getter;

public class Example {
    @Getter
    private String name;

    private int age; // getter 생성 안 됨
}
```
---
### @Getter의 주요 장점
1. **코드 간소화**
    - 수동으로 getter 메서드를 작성하지 않아도 됩니다.
2. **일관성**
    - 클래스의 모든 필드에 일관된 방식으로 getter 메서드를 생성합니다.
3. **가독성**
    - 클래스가 더 깔끔해지고, 중요한 로직에만 집중할 수 있습니다.
---
### @Getter와 JPA의 관계
`@Getter`는 **JPA 엔티티 클래스**에서 자주 사용됩니다.  
JPA는 데이터베이스 작업 시 기본적으로 getter 메서드를 호출해 필드 값을 읽기 때문에, 필드의 **캡슐화를 유지**하면서도 데이터에 접근할 수 있도록 getter를 제공해야 합니다.
ex)
```java
@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
}

```
위 코드에서 `@Getter`는 `getId()`, `getTitle()`, `getContent()` 메서드를 자동으로 생성하므로, JPA가 각 필드의 값을 읽을 수 있게 됩니다.

---
### 추가 옵션: `@Getter`의 속성

`@Getter`는 특정 필드에 대한 접근 제어를 설정할 수도 있습니다.
1. **`value` 속성**
    - getter의 접근 수준을 제한할 수 있습니다.
```java
import lombok.Getter;

public class Example {
    @Getter(AccessLevel.PRIVATE) // getter는 private으로 제한
    private String name;
}
```
2. **`lazy` 속성** (Lombok v1.18.8 이상)
- 성능을 위해 lazy-loading getter를 생성할 수 있습니다.
```java
import lombok.Getter;

public class Example {
    @Getter(lazy = true)
    private final String expensiveValue = computeExpensiveValue();

    private String computeExpensiveValue() {
        // 복잡한 계산
        return "value";
    }
}
```
---
### 정리
- `@Getter`는 클래스 또는 필드에 대해 getter 메서드를 자동으로 생성하여 **코드 중복을 줄이고 유지보수를 쉽게** 합니다.
- JPA 엔티티 클래스와 함께 사용하면, 데이터베이스와 객체 간의 데이터 접근이 간편해집니다.
- 필요에 따라 접근 수준을 조정하거나 추가 옵션을 활용하여 더 정교하게 사용할 수도 있습니다.