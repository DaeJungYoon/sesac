# @ExceptionHandler
- `@ExceptionHandler`는 **Spring Framework**에서 제공하는 어노테이션으로, 컨트롤러에서 발생하는 특정 예외를 처리하기 위해 사용됩니다. 
- 예외가 발생했을 때 해당 예외를 처리하는 메서드를 지정할 수 있어, 예외에 대한 응답을 커스터마이징하거나 추가 로직을 실행할 수 있습니다.

---

### 주요 특징

1. **특정 예외 처리**
    - 컨트롤러에서 발생하는 특정 타입의 예외를 처리하도록 메서드를 매핑합니다.
2. **로컬 예외 처리**
    - 특정 컨트롤러에서 발생한 예외만 처리하며, 전역적으로 처리하려면 `@ControllerAdvice`를 사용합니다.
3. **유연한 예외 대응**
    - 예외 메시지 수정, HTTP 상태 코드 변경, 로그 작성 등 예외 발생 시 다양한 동작을 구현할 수 있습니다.
---

### 기본 사용법
```java
@RestController
public class MyController {

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return a / b; // b가 0이면 ArithmeticException 발생
    }

    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException e) {
        return "Cannot divide by zero: " + e.getMessage();
    }
}
```
#### 설명

- `/divide?a=10&b=0` 요청 시 `ArithmeticException`이 발생합니다.
- `@ExceptionHandler(ArithmeticException.class)`로 매핑된 메서드가 호출되어 예외를 처리합니다.

---

### 다양한 예외 처리

#### 1. **여러 예외 처리**

여러 타입의 예외를 한 메서드에서 처리할 수 있습니다.
```java
@ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
public String handleMultipleExceptions(Exception e) {
    return "Error occurred: " + e.getMessage();
}
```
#### 2. **응답 상태 코드 변경**

`ResponseEntity`를 사용해 HTTP 상태 코드와 응답 내용을 커스터마이즈할 수 있습니다.
```java
@ExceptionHandler(IllegalArgumentException.class)
public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
    return new ResponseEntity<>("Invalid input: " + e.getMessage(), HttpStatus.BAD_REQUEST);
}
```
---

### `@ExceptionHandler`와 전역 예외 처리 비교

#### 로컬 처리

`@ExceptionHandler`는 선언된 컨트롤러 클래스 내에서만 동작합니다.

#### 전역 처리

전역 예외 처리를 원하면 `@ControllerAdvice`와 함께 사용합니다.
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```
- 모든 컨트롤러에서 발생한 예외를 처리할 수 있습니다.

---

### 왜 `@ExceptionHandler`를 사용하는가?

1. **컨트롤러 단위 예외 처리**
    
    - 특정 컨트롤러의 요구에 맞게 커스터마이징된 예외 처리를 구현할 수 있습니다.
2. **가독성과 유지보수성 향상**
    
    - 예외 처리 로직을 컨트롤러 메서드와 분리하여 코드 가독성을 높이고 유지보수를 쉽게 만듭니다.
3. **유연한 응답 제공**
    
    - 사용자 친화적인 메시지와 적절한 HTTP 상태 코드를 반환할 수 있습니다.

---

### 예제: 사용자 정의 예외 처리

#### 사용자 정의 예외 클래스
```java
public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super(message);
    }
}
```
#### 컨트롤러에서 예외 발생
```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        if (id <= 0) {
            throw new CustomNotFoundException("User not found with id: " + id);
        }
        return "User " + id;
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<String> handleCustomNotFound(CustomNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
```
#### 결과

- `/users/-1` 요청 시:
    - **HTTP 404 NOT FOUND**
    - 응답 본문: `"User not found with id: -1"`

---

### 결론

`@ExceptionHandler`는 Spring 애플리케이션에서 특정 예외를 처리하기 위해 사용되며, **컨트롤러 단위**로 예외 처리 로직을 간단하게 구현할 수 있는 강력한 도구입니다. 사용자 경험을 개선하고, 안정적인 애플리케이션 동작을 보장하는 데 중요한 역할을 합니다.