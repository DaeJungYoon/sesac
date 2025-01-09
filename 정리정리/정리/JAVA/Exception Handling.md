### Exception Handling (예외 처리)

- **Exception Handling**은 프로그램 실행 중 발생할 수 있는 **예외(Exception)** 를 감지하고, 이를 적절히 처리하여 프로그램이 비정상적으로 종료되지 않도록 하는 과정입니다.
- 이를 통해 안정적인 사용자 경험을 제공하고, 오류의 원인을 쉽게 파악할 수 있도록 도와줍니다.

---

### 예외(Exception)란?

- **예외(Exception)**: 프로그램 실행 중 예기치 못한 상황이나 오류가 발생한 경우를 말합니다.
    - 예: 0으로 나누기, 배열 인덱스 초과, null 참조, 파일을 찾을 수 없음 등.

#### 예외의 종류

1. **Checked Exception**
    - 컴파일 시점에 반드시 처리해야 하는 예외.
    - 예: `IOException`, `SQLException`
2. **Unchecked Exception**
    - 런타임 시점에 발생하며, 명시적으로 처리하지 않아도 컴파일 에러는 발생하지 않음.
    - 예: `NullPointerException`, `ArrayIndexOutOfBoundsException`
3. **Error**
    - 시스템 레벨의 심각한 문제로, 애플리케이션에서 복구 불가능한 경우.
    - 예: `OutOfMemoryError`, `StackOverflowError`

---

### Java에서의 Exception Handling

#### 1. `try-catch` 블록
예외가 발생할 가능성이 있는 코드를 `try` 블록에 넣고, 예외를 처리할 코드를 `catch` 블록에 작성합니다.

```java
try {
    int result = 10 / 0; // 예외 발생
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero: " + e.getMessage());
}
```
#### 2. `try-catch-finally` 블록
`finally` 블록은 예외 발생 여부와 상관없이 항상 실행됩니다. 자원 해제 등에 사용됩니다.
```java
try {
    int[] arr = {1, 2};
    System.out.println(arr[2]); // 예외 발생
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index out of bounds: " + e.getMessage());
} finally {
    System.out.println("Execution complete.");
}
```
#### 3. `throw` 키워드
예외를 명시적으로 발생시킬 때 사용합니다.
```java
public void validateAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or above");
    }
}
```
#### 4. `throws` 키워드

메서드에서 발생할 수 있는 예외를 호출자에게 전달합니다.
```java
public void readFile(String path) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(path));
}
```
---

### Spring에서의 Exception Handling

#### 1. **기본 예외 처리**

Spring은 기본적으로 발생한 예외를 처리해 HTTP 상태 코드와 메시지를 반환합니다.

#### 2. **@ExceptionHandler**

컨트롤러에서 특정 예외를 처리하기 위한 어노테이션입니다.
```java
@RestController
public class MyController {

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        return "Null pointer exception occurred: " + e.getMessage();
    }
}
```
#### 3. **@ControllerAdvice**

애플리케이션 전역에서 발생한 예외를 처리할 수 있도록 지원하는 어노테이션입니다.
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```
---

### 왜 Exception Handling이 중요한가?

1. **프로그램 안정성 유지**
    
    - 예외가 발생하더라도 프로그램이 종료되지 않고 정상적으로 동작을 이어갈 수 있습니다.
2. **오류 디버깅 용이**
    
    - 예외 메시지와 스택 트레이스를 통해 문제의 원인을 쉽게 파악할 수 있습니다.
3. **사용자 경험 향상**
    
    - 적절한 오류 메시지와 안내를 제공하여 사용자가 당황하지 않도록 합니다.
4. **자원 관리 효율성**
    
    - `finally` 블록 등을 사용해 자원 누수를 방지할 수 있습니다.

---

### Best Practices

1. **구체적인 예외 처리**
    
    - 모든 예외를 `Exception`으로 처리하지 말고, 구체적인 예외를 처리하세요.
2. **전역 예외 처리 사용**
    
    - Spring에서는 `@ControllerAdvice`를 활용해 전역 예외 처리를 구현하세요.
3. **적절한 로그 기록**
    
    - 발생한 예외를 로그로 기록하여 문제를 추적할 수 있도록 하세요.
4. **사용자 친화적인 메시지 제공**
    
    - 내부 오류를 그대로 노출하지 말고, 사용자에게 적절한 메시지를 제공하세요.

---

### 결론

Exception Handling은 예외로 인해 프로그램이 중단되지 않도록 안전장치를 제공하며, 안정성과 유지보수성을 향상시키는 필수적인 기법입니다. Spring에서는 편리한 어노테이션과 전역 처리 방법을 제공하여 효율적으로 예외를 관리할 수 있습니다.