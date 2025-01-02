# @RequiredArgsConstructor
- **Lombok**에서 제공하는 어노테이션으로, **클래스의 `final` 필드나 `@NonNull`이 붙은 필드만 초기화하는 생성자를 자동으로 생성**해주는 편리한 기능입니다.
---
### 사용 목적

1. **생성자 자동 생성**:
    
    - 클래스 내의 `final` 필드 또는 `@NonNull` 필드에 대한 **필수 생성자**를 자동으로 만들어줍니다.
    - 의존성 주입(Dependency Injection)에서 특히 유용합니다.
2. **코드 간소화**:
    
    - 생성자를 직접 작성할 필요가 없어 코드가 간결해지고, 유지보수성이 향상됩니다.

---

## 동작 방식

`@RequiredArgsConstructor`는 다음 두 가지 조건을 가진 필드만 포함하는 생성자를 자동 생성합니다:

- `final`이 붙은 필드
- `@NonNull`이 붙은 필드 (컴파일 시점에 필수 값임을 보장)

예를 들어, 아래와 같은 클래스가 있을 때:
```java
@RequiredArgsConstructor
public class Example {
    private final String name;
    private final int age;
    private String optionalField;
}
```
Lombok은 다음과 같은 생성자를 자동으로 생성합니다
```java
public Example(String name, int age) {
    this.name = name;
    this.age = age;
}
```
---
## 장점
1. **코드 간결성**
    - 생성자를 수동으로 작성하지 않아도 됩니다.
2. **불변성 보장**
    - `final` 필드로 선언된 의존성은 생성 이후 변경할 수 없습니다.
3. **Spring과의 시너지**
    - 생성자 주입 방식이 권장되는 Spring에서 매우 자연스럽게 사용할 수 있습니다.
4. **컴파일 타임 안전성**
    - 의존성이 누락되면 컴파일 오류를 발생시키므로, 런타임 오류를 방지할 수 있습니다.

---

## 추가 어노테이션 비교
- **`@AllArgsConstructor`**: 모든 필드(`final` 포함/제외)에 대한 생성자를 생성합니다.
- **`@NoArgsConstructor`**: 파라미터가 없는 기본 생성자를 생성합니다.
- **`@RequiredArgsConstructor`**: `final` 또는 `@NonNull` 필드만 포함한 생성자를 생성합니다.

---

## 정리
`@RequiredArgsConstructor`는 생성자 주입 방식으로 의존성을 관리하는 Spring 애플리케이션에서 특히 유용하며, 코드 작성의 반복 작업을 줄여 생산성과 가독성을 높여줍니다.