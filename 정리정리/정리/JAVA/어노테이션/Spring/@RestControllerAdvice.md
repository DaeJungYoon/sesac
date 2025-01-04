# @RestControllerAdvice
- `@RestControllerAdvice`는 Spring 프레임워크에서 제공하는 애너테이션으로, 애플리케이션 전역에서 발생하는 예외를 처리하기 위한 도구입니다. 이 애너테이션은 주로 RESTful 웹 서비스에서 사용되며, 컨트롤러에만 국한되지 않고 애플리케이션 전체에 적용할 수 있는 예외 처리 로직을 작성하는 데 사용됩니다.

### 주요 특징

1. **예외 처리**:
    
    - `@ExceptionHandler`와 함께 사용하여 특정 예외를 처리할 수 있습니다.
    - 예외가 발생했을 때 적절한 HTTP 응답을 반환하도록 설정할 수 있습니다.
2. **전역 적용**:
    
    - 컨트롤러에 종속되지 않고, 애플리케이션의 모든 컨트롤러에서 발생하는 예외를 처리합니다.
3. **JSON 응답**:
    
    - 주로 REST 컨트롤러(`@RestController`)와 함께 사용되기 때문에 기본적으로 JSON 형태로 응답합니다.
4. **조합 애너테이션**:
    
    - `@ControllerAdvice`와 `@ResponseBody`의 조합입니다.
    - 따라서 반환값은 자동으로 JSON이나 XML 같은 HTTP 응답 본문으로 직렬화됩니다.

---

### 사용 방법
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
    }
}
```
---
### 주요 애너테이션

- **@ExceptionHandler**: 특정 예외를 처리할 메서드에 사용.
- **@ModelAttribute**: 모델 데이터를 변환하거나 조작할 때 사용.
- **@InitBinder**: 특정 요청 파라미터를 바인딩하거나 검증할 때 사용.

### 주요 장점

1. 코드의 **재사용성** 증가: 모든 컨트롤러에서 공통으로 발생하는 예외 처리 로직을 한 곳에서 관리.
2. **가독성** 향상: 각 컨트롤러에 흩어진 예외 처리 코드를 제거.
3. **유지보수성** 개선: 변경 사항이 있을 때 한 곳에서 수정 가능.

`@RestControllerAdvice`는 REST API를 설계할 때 공통적인 예외 처리 로직을 작성하고 싶을 때 매우 유용합니다.