# @AllArgsConstructor
- `@AllArgsConstructor`는 Lombok 라이브러리가 제공하는 애너테이션으로, 클래스의 모든 필드에 대해 자동으로 **전체 필드 생성자**를 생성해줍니다.
- 이 생성자는 객체를 초기화할 때 모든 필드 값을 매개변수로 받아서 설정합니다.

---
### 주요 특징

1. **전체 필드 초기화**:
    - 클래스에 선언된 모든 필드를 매개변수로 받는 생성자를 자동 생성.
    - **`final` 필드**와 일반 필드를 모두 포함.
2. **코드 간소화**:
    - 생성자를 수동으로 작성할 필요가 없어짐.
3. **Immutable 객체 생성**:
    - `final` 필드와 함께 사용하여 불변 객체를 쉽게 생성 가능.
4. **호환성**:
    - 다른 Lombok 애너테이션(`@Builder`, `@NoArgsConstructor` 등)과 함께 사용 가능.

---

### 사용 방법
```java
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String email;
}
```
---

**객체 생성 예제**:
```java
public class Main {
    public static void main(String[] args) {
        User user = new User("Alice", 25, "alice@example.com");
        System.out.println(user);
    }
}
```
출력:
```less
User(name=Alice, age=25, email=alice@example.com)
```
---

### 주요 활용

#### 1. **`final` 필드와 함께 사용**
`@AllArgsConstructor`는 `final` 필드 초기화에도 적합합니다.
```java
@AllArgsConstructor
public class ImmutableUser {
    private final String name;
    private final int age;
}
```
---

#### 2. **다른 Lombok 애너테이션과 함께 사용**
- **`@NoArgsConstructor`**: 전체 필드 생성자와 기본 생성자를 모두 제공해야 할 경우 사용.
```java
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
}
```
- **`@Builder`**: 빌더 패턴과 함께 사용하여 다양한 객체 생성 방법 제공.
```java
@AllArgsConstructor
@Builder
public class Car {
    private String model;
    private String color;
}

Car car = Car.builder()
             .model("Tesla")
             .color("Red")
             .build();
```
---

### 주의사항
1. **필드가 많을 경우**:
    - 필드가 많으면 생성자의 매개변수가 길어져 가독성이 떨어질 수 있음. 이 경우 `@Builder`를 고려하는 것이 좋습니다.
2. **기본 생성자와 충돌**:
    - `@AllArgsConstructor`는 모든 필드를 초기화해야 하므로, 기본 생성자(`@NoArgsConstructor`)와 함께 사용하려면 명시적으로 추가해야 합니다.
3. **Lombok 의존성 필요**:
    - 프로젝트에 Lombok이 추가되어 있어야 합니다.
	- **Gradle 의존성**:
```gradle
implementation 'org.projectlombok:lombok:1.18.30'
annotationProcessor 'org.projectlombok:lombok:1.18.30'
```
4. **IDE 플러그인 설치**:
    - IntelliJ IDEA나 Eclipse에서 Lombok 플러그인을 설치해야 생성자가 자동으로 인식됩니다.

---
### 결론

`@AllArgsConstructor`는 클래스의 모든 필드를 초기화하는 생성자를 손쉽게 만들어주기 때문에 DTO(Data Transfer Object), VO(Value Object) 등을 설계할 때 유용합니다. 하지만, 필드가 많거나 선택적 매개변수를 지원해야 한다면 `@Builder`와 같은 애너테이션과 조합해서 사용하는 것이 좋습니다. 😊
