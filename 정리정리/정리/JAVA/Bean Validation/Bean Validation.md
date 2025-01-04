# Bean Validation
- **Bean Validation**은 Java 기반 애플리케이션에서 객체의 데이터 유효성을 검증하기 위한 표준 API입니다. 
- 주로 사용자의 입력값이나 비즈니스 로직에서 사용되는 객체의 속성 값이 예상된 조건을 충족하는지 확인하는 데 사용됩니다.
- Java Bean Validation은 JSR-303 및 JSR-380(Bean Validation 2.0)을 기반으로 합니다. Spring 프레임워크에서는 이 표준을 Hibernate Validator를 통해 구현하고 제공합니다.

---

### 주요 개념

1. **제약 조건(Constraints)**:    
    - 유효성 검사를 위한 규칙을 정의합니다.
    - 예: `@NotNull`, `@Size`, `@Min`, `@Max` 등.
2. **애너테이션 기반**:
    - 객체의 필드나 메서드에 유효성 검사 규칙을 애너테이션으로 정의합니다.
3. **표준 인터페이스**:
    - 유효성 검증을 수행하는 공통 API를 제공합니다.
4. **통합성**:
    - Spring과 같은 프레임워크에 쉽게 통합할 수 있으며, DTO(데이터 전송 객체) 및 엔티티 레벨에서 데이터 검증을 수행할 수 있습니다.

---

### 사용 방법
#### 1. **의존성 추가**

Spring Boot를 사용하는 경우, Maven이나 Gradle에 Hibernate Validator 의존성을 추가합니다.

#### Gradle:
```Gradle
implementation 'org.springframework.boot:spring-boot-starter-validation'
```
---

#### 2. **제약 조건 애너테이션**

아래는 대표적인 애너테이션과 그 역할입니다:

|애너테이션|설명|
|---|---|
|`@NotNull`|값이 null이 아니어야 함|
|`@Size`|문자열, 배열, 컬렉션 등의 크기 제한|
|`@Min`|최소값|
|`@Max`|최대값|
|`@Pattern`|정규 표현식과 일치해야 함|
|`@Email`|유효한 이메일 주소여야 함|
|`@Past`|과거 날짜여야 함|
|`@Future`|미래 날짜여야 함|

---

#### 3. **사용 예제**

#### **DTO 클래스**
```java
import jakarta.validation.constraints.*;

public class UserDto {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @Email(message = "Invalid email address")
    private String email;

    // Getters and Setters
}
```
#### 컨트롤러
```java
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto) {
        // 유효성 검사가 통과되면 실행
        return ResponseEntity.ok("User created successfully");
    }
}
```
---

#### 4. **유효성 검사 실패 처리**

Spring에서는 `@Valid`나 `@Validated`를 사용하여 유효성 검사를 수행하며, 검증 실패 시 자동으로 `MethodArgumentNotValidException` 또는 `ConstraintViolationException`이 발생합니다. 이를 전역적으로 처리하려면 다음과 같이 설정할 수 있습니다:
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

```
---

### Bean Validation의 장점

1. **간결성**: 객체에 유효성 검사를 정의하는 데 필요한 코드를 최소화.
2. **유지보수성**: 객체 자체에 검증 로직이 포함되어 있어 한 곳에서 관리 가능.
3. **프레임워크 통합**: Spring, JPA, REST API 등과 쉽게 연동 가능.
4. **확장 가능성**: 사용자 정의 검증 애너테이션을 만들어 특수한 유효성 검사를 구현할 수 있음.

---

Bean Validation은 클라이언트 입력을 검증하거나 비즈니스 로직의 무결성을 보장하는 데 매우 유용합니다. 💡