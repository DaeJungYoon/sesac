# @ExceptionHandler
- `@ExceptionHandler`는 **Spring MVC**에서 예외 처리 메커니즘을 제공하기 위한 어노테이션입니다.  
- 컨트롤러 계층에서 발생하는 특정 예외를 잡아 **사용자 정의 로직**으로 처리할 수 있도록 합니다.

---

### **@ExceptionHandler의 주요 기능**

1. **특정 예외 처리**
    - 지정된 예외가 발생했을 때 해당 메서드가 호출됩니다.
2. **응답 커스터마이징**
    - 사용자에게 반환할 응답 데이터를 직접 정의할 수 있습니다.
3. **전역 또는 개별 컨트롤러에서 사용 가능**
    - 컨트롤러 클래스 내부에서 개별적으로 사용하거나, 전역 예외 처리 클래스로 분리할 수 있습니다.

---
### **사용법**

#### 1. 특정 컨트롤러에서 예외 처리
```java
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        return new User(id, "John Doe");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
```
- **동작 방식**:
    - `/user/-1` 요청 시 `IllegalArgumentException`이 발생합니다.
    - `@ExceptionHandler(IllegalArgumentException.class)`가 해당 예외를 처리하여 사용자에게 400 Bad Request 응답을 반환합니다.

#### 2. 전역 예외 처리
전역적으로 모든 컨트롤러의 예외를 처리하려면 `@ControllerAdvice`와 함께 사용합니다.
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("Invalid argument: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}
```
- **동작 방식**:
    - 모든 컨트롤러에서 발생한 `IllegalArgumentException` 및 `Exception`을 전역적으로 처리합니다.

---
### **@ExceptionHandler의 장점**

1. **중앙 집중식 예외 처리**
    - 컨트롤러 로직에서 예외 처리 코드를 분리하여 코드의 가독성을 높입니다.
2. **유연한 응답 처리**
    - 사용자 친화적인 에러 메시지와 상태 코드를 반환할 수 있습니다.
3. **다양한 예외 처리**
    - 여러 종류의 예외를 세분화하여 각각 다르게 처리할 수 있습니다.
4. **Spring과의 긴밀한 통합**
    - Spring MVC의 요청-응답 사이클에 자연스럽게 통합됩니다.

---

### **@ExceptionHandler의 반환값**

`@ExceptionHandler` 메서드는 다양한 반환값을 가질 수 있습니다.

1. **`ResponseEntity`**: HTTP 응답 상태 코드와 메시지를 커스터마이징.
2. **`ModelAndView`**: 에러 페이지를 렌더링.
3. **`String`**: 에러 메시지를 간단히 반환.
4. **직접 응답 객체**: JSON 또는 XML 포맷으로 데이터 반환.

---

### **예제: JSON 응답 커스터마이징**
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException e) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("error", "Internal Server Error");
        errorResponse.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
```
**응답 예시**:
```json
{
    "status": 500,
    "error": "Internal Server Error",
    "message": "An unexpected error occurred"
}
```
---

### **유의사항**

1. **예외 우선순위**
    - 더 구체적인 예외 핸들러가 먼저 호출됩니다.
    - 예: `IllegalArgumentException` 핸들러 > `RuntimeException` 핸들러.
2. **컨트롤러 범위**
    - 컨트롤러 클래스 내부의 `@ExceptionHandler`는 해당 컨트롤러에서만 적용됩니다.
    - `@ControllerAdvice`를 사용하면 전역 적용됩니다.
3. **HTTP 상태 코드 관리**
    - 적절한 HTTP 상태 코드를 반환하도록 설계해야 합니다.  
        예: `400 Bad Request`, `404 Not Found`, `500 Internal Server Error` 등.
---
### 왜 `@ExceptionHandler`를 사용하는가?

1. **컨트롤러 단위 예외 처리**
    
    - 특정 컨트롤러의 요구에 맞게 커스터마이징된 예외 처리를 구현할 수 있습니다.
2. **가독성과 유지보수성 향상**
    
    - 예외 처리 로직을 컨트롤러 메서드와 분리하여 코드 가독성을 높이고 유지보수를 쉽게 만듭니다.
3. **유연한 응답 제공**
    
    - 사용자 친화적인 메시지와 적절한 HTTP 상태 코드를 반환할 수 있습니다.