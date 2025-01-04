# @Builder
- `@Builder`는 Lombok 라이브러리가 제공하는 애너테이션으로, 객체 생성 시 **Builder 패턴**을 자동으로 구현해주는 도구입니다. 이 패턴은 생성자나 Setter 메서드를 사용하지 않고, 읽기 쉽고 유연한 방식으로 객체를 생성할 수 있도록 합니다. 특히 매개변수가 많은 객체를 생성할 때 매우 유용합니다.

---

### 주요 특징

1. **가독성 향상**: 객체 생성 시 매개변수 순서에 상관없이 명시적으로 값을 설정할 수 있습니다.
2. **유연성**: 선택적으로 필드를 설정하거나, 필요 없는 필드를 생략할 수 있습니다.
3. **불변 객체 지원**: `@Builder`를 사용하면 불변 객체(Immutable Object)를 쉽게 생성할 수 있습니다.
4. **코드 간소화**: Builder 클래스를 수동으로 작성할 필요가 없습니다.

---

### 기본 사용법
```java
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class User {
    private String name;
    private int age;
    private String email;
}

```
#### 객체 생성
```java
public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                        .name("Alice")
                        .age(25)
                        .email("alice@example.com")
                        .build();
        System.out.println(user);
    }
}
```
출력:
```less
User(name=Alice, age=25, email=alice@example.com)
```
---

### 주요 기능

1. **필드 선택적 설정**:
    - 모든 필드를 설정하지 않아도 됩니다.
```java
User user = User.builder()
                .name("Bob")
                .build();

```
- **체이닝 방식**:
    - 각 필드 설정 메서드는 객체 자신을 반환하므로 체이닝으로 호출할 수 있습니다.
- **불변 객체 생성**:
    - 클래스 필드를 `final`로 설정하면 불변 객체를 쉽게 생성할 수 있습니다.
```java
@Builder
public class ImmutableUser {
    private final String name;
    private final int age;
}
```
---

### @Builder의 고급 사용법

1. **생성자와 함께 사용**: `@AllArgsConstructor`와 함께 사용하면 기본 생성자가 없는 클래스에서도 작동합니다.
```java
import lombok.Builder;
import lombok.AllArgsConstructor;

@Builder
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
}
```
2. **메서드 수준 @Builder**: 특정 메서드의 반환 객체에만 Builder 패턴을 적용할 수도 있습니다.
```java
public class Car {
    private String model;
    private String color;

    @Builder
    public static Car createCar(String model, String color) {
        Car car = new Car();
        car.model = model;
        car.color = color;
        return car;
    }
}

Car car = Car.createCar()
             .model("Tesla")
             .color("Red")
             .build();
```
3. **Custom Builder 클래스**: Builder 로직을 커스터마이징하려면 Builder 클래스를 직접 정의할 수 있습니다.
```java
@Builder
public class CustomUser {
    private String name;
    private int age;

    public static class CustomUserBuilder {
        public CustomUserBuilder name(String name) {
            this.name = "Prefix-" + name; // 이름에 접두어 추가
            return this;
        }
    }
}
```
### 주의사항
1. **필드 이름 충돌**:
    - 필드 이름과 동일한 이름의 메서드가 있으면 충돌할 수 있습니다.
2. **사용 시 Lombok 의존성 필요**:
    - Lombok을 사용하려면 프로젝트에 Lombok 의존성을 추가해야 합니다.
#### Gradle 의존성
```gradle
implementation 'org.projectlombok:lombok:1.18.30'
annotationProcessor 'org.projectlombok:lombok:1.18.30'
```
3. **IDE 설정**:
    - Lombok을 사용할 때 IntelliJ IDEA나 Eclipse에서는 플러그인을 설치해야 합니다.

---

`@Builder`는 코드의 가독성과 유지보수성을 높이고, 객체 생성 과정을 단순화하는 데 매우 유용한 도구입니다. 😊