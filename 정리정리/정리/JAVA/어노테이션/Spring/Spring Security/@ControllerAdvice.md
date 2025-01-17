# @**ControllerAdvice**
- **`@ControllerAdvice`**는 Spring Framework에서 제공하는 어노테이션으로, 애플리케이션 전역에서 발생하는 **예외(Exception)**를 처리할 수 있는 **전역 예외 처리 클래스**를 정의하기 위해 사용됩니다. 
- 이를 통해 모든 컨트롤러에서 발생한 예외를 한 곳에서 일괄적으로 관리할 수 있습니다.

---

### 주요 특징

1. **전역 예외 처리**
    
    - 모든 컨트롤러에서 발생한 예외를 처리할 수 있습니다.
    - 개별 컨트롤러의 `@ExceptionHandler`보다 상위 레벨에서 동작합니다.
2. **AOP 기반 동작**
    
    - Spring의 AOP(Aspect-Oriented Programming)를 사용해 컨트롤러 메서드 호출 시 예외 처리 로직을 적용합니다.
3. **유연한 처리**
    
    - 특정 패키지, 특정 예외만 처리하도록 설정할 수 있습니다.

---

### 기본 사용법

#### 1. `@ControllerAdvice`와 `@ExceptionHandler` 조합
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException e) {
        return new ResponseEntity<>("Arithmetic Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```
- 모든 컨트롤러에서 `ArithmeticException` 발생 시 첫 번째 메서드가 호출됩니다.
- 그 외의 예외는 두 번째 메서드가 처리합니다.

---

### 주요 메서드와 어노테이션

#### 1. `@ExceptionHandler`

특정 예외를 처리하는 메서드에 사용됩니다.
```java
@ExceptionHandler(NullPointerException.class)
public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
    return new ResponseEntity<>("Null Pointer Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
}
```
#### 2. `@ModelAttribute`

모든 컨트롤러에 공통으로 제공할 데이터를 정의할 때 사용합니다.
```java
@ModelAttribute("defaultData")
public String provideDefaultData() {
    return "Default data for all controllers";
}
```

#### 3. `@InitBinder`

컨트롤러에서 사용되는 데이터 바인딩 설정을 커스터마이징할 때 사용됩니다.
```java
@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.setDisallowedFields("id");
}
```

---

### 특정 범위에서만 적용하기

#### 1. **특정 패키지 제한**

`@ControllerAdvice`에 `basePackages` 속성을 추가하여 특정 패키지에만 적용되도록 설정할 수 있습니다.
```java
@ControllerAdvice(basePackages = "com.example.myapp.controllers")
public class SpecificControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal Argument: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
```
#### 2. **특정 클래스 제한**

`assignableTypes`를 사용해 특정 컨트롤러 클래스에서만 동작하도록 설정할 수 있습니다.
```java
@ControllerAdvice(assignableTypes = {MyController.class, AnotherController.class})
public class SpecificControllerAdvice {
    // ...
}
```
---

### 왜 `@ControllerAdvice`를 사용하는가?

1. **중앙화된 예외 처리**
    
    - 컨트롤러마다 중복되는 예외 처리 코드를 제거하고, 모든 예외를 한 곳에서 관리할 수 있습니다.
2. **유지보수성 향상**
    
    - 예외 처리 로직을 중앙화하여 코드의 가독성과 유지보수성을 크게 향상시킵니다.
3. **공통 로직 재사용**
    
    - 공통 데이터나 설정(`@ModelAttribute`, `@InitBinder`)을 모든 컨트롤러에서 재사용할 수 있습니다.
4. **전역 예외 처리**
    
    - RESTful API에서 발생하는 예외에 대해 일관된 응답을 반환할 수 있습니다.

---

### 실전 예제: JSON 응답 커스터마이징

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception e) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("message", e.getMessage());
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

---

### `@ControllerAdvice`와 REST API

RESTful 애플리케이션에서는 예외 발생 시 일관된 형식의 응답을 반환하는 것이 중요합니다. `@ControllerAdvice`를 사용해 REST API에서 발생하는 모든 예외를 JSON 응답으로 변환할 수 있습니다.

#### 예제: 사용자 정의 예외 클래스
```java
public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super(message);
    }
}
```
#### 전역 예외 처리 클래스
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCustomException(CustomNotFoundException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
```
---

### 결론

`@ControllerAdvice`는 Spring에서 전역적으로 예외를 처리하기 위한 강력한 도구입니다. RESTful API 개발이나 대규모 애플리케이션에서 공통적인 예외 처리 로직을 중앙화하여 코드 중복을 줄이고 유지보수성을 높이는 데 필수적입니다.

4o