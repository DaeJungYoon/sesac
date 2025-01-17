# @RequestBody
- Spring Framework에서 HTTP 요청의 본문(body)에 포함된 데이터를 Java 객체로 변환(mapping)할 때 사용하는 어노테이션입니다. 
- 주로 RESTful API에서 클라이언트가 JSON 또는 XML과 같은 형식의 데이터를 서버로 전송할 때 사용됩니다.

### 동작 원리
- 클라이언트가 요청 본문에 데이터를 포함해 서버로 전송하면, Spring의 `HttpMessageConverter`가 요청 데이터를 Java 객체로 변환합니다.
- 이 변환 작업은 Jackson 또는 Gson과 같은 라이브러리를 통해 이루어지며, 기본적으로 JSON 형식을 지원합니다.

---
### 사용 예제
#### 예제 1: 기본적인 JSON 요청 처리
```java
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String createUser(@RequestBody User user) {
        return "User created: " + user.getName();
    }
}

```
#### 요청(JSON)
```json
{
    "name": "John Doe",
    "email": "john.doe@example.com"
}
```

#### 설명

1. 클라이언트가 위와 같은 JSON 데이터를 POST 요청의 본문에 포함해 전송합니다.
2. Spring은 JSON 데이터를 `User` 클래스의 객체로 변환합니다.
3. `createUser` 메서드는 변환된 `User` 객체를 처리합니다.

---

### `User` 클래스
```java
public class User {
    private String name;
    private String email;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

```

---

### 예제 2: 배열 또는 리스트 처리

클라이언트가 JSON 배열 데이터를 보낼 수도 있습니다.

```java
@PostMapping("/batch")
public String createUsers(@RequestBody List<User> users) {
    return "Number of users created: " + users.size();
}
```

#### 요청(JSON)
```json
[
    {"name": "Alice", "email": "alice@example.com"},
    {"name": "Bob", "email": "bob@example.com"}
]
```

---

### 주요 특징 및 장점

1. **데이터 변환**:
    
    - JSON, XML 등 다양한 형식의 데이터를 Java 객체로 쉽게 변환.
    - `HttpMessageConverter`가 자동으로 처리.
2. **유연성**:
    
    - 단일 객체, 리스트, 맵 등 다양한 Java 타입과 호환.
3. **간결성**:
    
    - 별도의 파싱 작업 없이 요청 데이터를 바로 사용할 수 있음.

---

### 참고: Content-Type 헤더

클라이언트 요청의 `Content-Type` 헤더는 서버가 데이터를 올바르게 해석하는 데 중요합니다.

- JSON 데이터: `Content-Type: application/json`
- XML 데이터: `Content-Type: application/xml`

---

### 주의사항

1. **요청 데이터가 유효하지 않을 경우**:
    
    - 잘못된 형식의 데이터는 변환 실패로 이어져 `HttpMessageNotReadableException`이 발생할 수 있습니다.
    - 이를 방지하기 위해 적절한 예외 처리를 구현하거나, 데이터 유효성 검사를 추가해야 합니다.
2. **필수 필드 확인**:
    
    - Lombok의 `@NotNull` 또는 Spring의 `@Valid`와 같은 유효성 검사를 사용할 수 있습니다:
        
```java
public String createUser(@Valid @RequestBody User user) {
    // 유효성 검사 실패 시 에러 반환
    return "User created";
}
```