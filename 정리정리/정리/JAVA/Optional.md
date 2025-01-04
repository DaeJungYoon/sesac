# Optional
- `Optional`은 Java 8에서 도입된 클래스(java.util.Optional)로, **null 값을 처리하는 데 도움을 주는 컨테이너**입니다. 
- 값이 존재할 수도 있고 없을 수도 있는 상황에서 사용하며, 
- null로 인한 문제(예: `NullPointerException`)를 방지하고 더 명확하고 안전한 코드를 작성할 수 있도록 도와줍니다.

---

### 주요 특징

1. **값의 유무를 표현**:
    - 값이 존재하면 해당 값을 담고, 값이 없으면 비어 있는(`empty`) 상태를 가집니다.
2. **null 방지**:
    - `null`을 직접 사용하지 않고 `Optional` 객체로 값을 처리하여 `NullPointerException`을 예방합니다.
3. **명시적인 흐름 제어**:
    - 값이 없는 경우에 대한 처리를 강제적으로 구현하도록 유도합니다.

---

### Optional 생성 방법

#### 1. `of()`
- `null`이 아닌 값을 포함하는 `Optional` 객체를 생성.
```java
Optional<String> optional = Optional.of("Hello");
```
#### 2. `ofNullable()`
- 값이 `null`일 수도 있는 상황에서 사용.
```java
Optional<String> optional = Optional.ofNullable(null);
```
#### 3. `empty()`
- 비어 있는 `Optional` 객체를 생성.
```java
Optional<String> optional = Optional.empty();
```
---
### Optional의 주요 메서드

1. **값 확인**
    - `isPresent()`: 값이 존재하면 `true` 반환.
    - `isEmpty()`: 값이 없으면 `true` 반환(Java 11 이상).
```java
if (optional.isPresent()) {
    System.out.println("값이 존재합니다.");
}
```
2. **값 가져오기**
	- `get()`: 값을 반환, 값이 없으면 `NoSuchElementException` 발생.
	- `orElse(T other)`: 값이 없으면 기본값 반환.
	- `orElseGet(Supplier<? extends T> supplier)`: 값이 없으면 Supplier로 제공된 값 반환.
	- `orElseThrow()`: 값이 없으면 예외를 던짐.
```java
String value = optional.orElse("기본값");
```
3. **값 처리**
	- `ifPresent(Consumer<? super T> action)`: 값이 존재하면 해당 동작 수행.
	- `map(Function<? super T, ? extends U> mapper)`: 값을 변환하여 새로운 `Optional` 반환.
	- `flatMap(Function<? super T, Optional<U>> mapper)`: 중첩된 `Optional`을 평탄화.
```java
optional.ifPresent(value -> System.out.println("값: " + value));

Optional<Integer> length = optional.map(String::length);
```
---

### 사용 예제

#### 기본 예제
```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("Hello");

        // 값 확인 및 처리
        optional.ifPresent(value -> System.out.println("값: " + value));

        // 값 가져오기
        String result = optional.orElse("기본값");
        System.out.println(result);
    }
}
```
#### 데이터베이스 조회와 함께 사용
```java
public Optional<User> findById(Long id) {
    // 값이 없을 수도 있는 데이터베이스 조회 결과를 반환
    return userRepository.findById(id);
}

public void processUser(Long id) {
    Optional<User> userOptional = findById(id);

    userOptional.ifPresent(user -> {
        System.out.println("사용자 이름: " + user.getName());
    });
}
```
#### 복잡한 연산 처리
```java
Optional<String> optional = Optional.ofNullable("Example");

String result = optional.map(String::toUpperCase)
                        .orElse("기본값");
System.out.println(result); // 출력: EXAMPLE
```

---

### Optional의 장점

1. **NullPointerException 방지**:
    - null 값을 안전하게 처리할 수 있습니다.
2. **가독성 향상**:
    - 값이 없을 때의 처리를 명시적으로 작성하므로 코드가 더 명확해집니다.
3. **함수형 프로그래밍 지원**:
    - `map`, `flatMap`, `ifPresent` 등을 사용하여 함수형 스타일로 데이터를 처리할 수 있습니다.

---

### Optional 사용 시 주의사항

1. **필드에 사용 금지**:
    - `Optional`은 클래스 필드로 사용하는 데 적합하지 않습니다. `Optional`은 값이 있을 수도, 없을 수도 있는 **임시 결과**를 나타내는 데 사용됩니다.
```java
// 잘못된 사용
public class User {
    private Optional<String> name; // 비추천
}
```
2 **`get()` 사용 제한**:  
    - 값이 없는 경우 예외를 발생시키므로, 가급적 `orElse`, `orElseGet`, `orElseThrow`를 사용하세요.
3 **성능 고려**:
    - 불필요한 `Optional` 사용은 오히려 성능을 저하시킬 수 있으므로, 꼭 필요한 경우에만 사용하세요.

---

### 결론

`Optional`은 null을 안전하게 처리하고 코드를 더 명확하게 만드는 강력한 도구입니다. 하지만 모든 상황에서 사용할 필요는 없으며, 적절히 활용하는 것이 중요합니다. 😊