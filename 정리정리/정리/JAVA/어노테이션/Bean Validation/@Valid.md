# @Valid
- jakarta
- `@Valid`는 Java Bean Validation에서 제공하는 어노테이션으로, **입력 값 검증**을 수행하기 위해 사용됩니다. 이 어노테이션은 주로 **Spring Framework**와 **Hibernate Validator**를 통해 사용됩니다.

---

### **주요 특징**

1. **입력 값 검증**

    - `@Valid`는 객체 내부의 필드에 대해 선언된 검증 조건을 확인합니다.
    - 예를 들어, 클래스 필드에 선언된 `@NotNull`, `@Size`, `@Pattern` 같은 검증 어노테이션이 유효한지 확인합니다.
2. **검증 위치**
    - **메서드 파라미터**: 컨트롤러의 요청 데이터를 검증합니다.
    - **엔티티 필드**: 데이터베이스에 저장되기 전에 검증을 수행합니다.
3. **예외 발생**
    - 검증 조건을 만족하지 않으면 `javax.validation.ConstraintViolationException` 또는 Spring에서 처리된 예외가 발생합니다.

---

### **사용 예제**

#### 1. **DTO 클래스 정의**

DTO 클래스에 검증 어노테이션 추가:
```java
public class UserRequestDto {

    @NotNull(message = "이름은 필수 항목입니다.")
    @Size(min = 2, max = 50, message = "이름은 2자 이상 50자 이하로 입력해야 합니다.")
    private String name;

    @Email(message = "유효한 이메일 주소를 입력해야 합니다.")
    private String email;

    @Min(value = 18, message = "나이는 최소 18세 이상이어야 합니다.")
    private int age;

    // Getters and Setters
}
```
#### 2. **컨트롤러에서 @Valid 사용**
요청 데이터를 검증:
```java
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        // 요청 데이터가 검증을 통과하면 처리 로직 수행
        return ResponseEntity.ok("User created successfully!");
    }
}
```
#### 3. **예외 처리**
검증 실패 시 발생하는 예외를 처리:
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                                .getAllErrors()
                                .get(0)
                                .getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
```
---
### **주요 검증 어노테이션**

- `@NotNull`: 값이 `null`이면 안 됩니다.
- `@NotEmpty`: 빈 문자열은 허용하지 않습니다.
- `@NotBlank`: 공백만으로 이루어진 문자열은 허용하지 않습니다.
- `@Size`: 문자열이나 컬렉션의 크기를 제한합니다.
- `@Min`, `@Max`: 숫자의 최소값과 최대값을 지정합니다.
- `@Pattern`: 정규식을 이용한 값 검증.
- `@Email`: 이메일 형식 검증.

---

### **Spring에서 @Valid의 역할**

1. Spring은 Hibernate Validator를 기본 Bean Validation 구현체로 사용합니다.
2. `@Valid` 어노테이션을 통해 DTO 객체를 검증한 뒤, 조건을 충족하지 않으면 **자동으로 예외를 발생**시킵니다.
3. 검증 로직을 서비스 계층이나 컨트롤러에서 반복적으로 작성할 필요가 없어집니다.

---

### **추가 참고**

- `@Valid`는 **javax.validation.Valid** 패키지에서 제공됩니다.
- `@Validated`(Spring 전용)와 함께 사용될 수 있으며, 그룹 검증(Group Validation)과 같은 고급 기능을 지원합니다.