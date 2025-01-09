# @PostMapping
- `@PostMapping`은 **Spring Framework**에서 제공하는 어노테이션으로, **HTTP POST 요청**을 처리하기 위해 사용됩니다. 이 어노테이션은 컨트롤러 클래스의 메서드와 매핑되어 특정 URL로 들어오는 POST 요청에 대한 처리를 정의합니다.

---

### 주요 특징

1. **HTTP POST 요청 매핑**
    
    - 클라이언트가 지정된 URL로 POST 요청을 보냈을 때 해당 메서드가 실행됩니다.
2. **Request Body 처리**
    
    - 일반적으로 POST 요청은 클라이언트에서 서버로 데이터를 전송할 때 사용됩니다. `@PostMapping`은 폼 데이터나 JSON 데이터를 받을 때 자주 사용됩니다.
3. **간결한 코드**
    
    - `@RequestMapping(method = RequestMethod.POST)`를 사용하는 것보다 코드가 간결하고 가독성이 좋습니다.

---

### 사용법

#### 기본 사용
```java
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/create")
    public String createUser() {
        return "User created successfully!";
    }
}
```
- 클라이언트가 `/users/create` URL로 POST 요청을 보내면 `createUser` 메서드가 실행됩니다.

---

#### 요청 데이터 처리

##### 1. **폼 데이터 처리**
```java
@PostMapping("/submit")
public String handleForm(@RequestParam String name, @RequestParam int age) {
    return "Name: " + name + ", Age: " + age;
}
```
- **폼 데이터**: `name=John&age=30`
- **결과**: `Name: John, Age: 30`

##### 2. **JSON 데이터 처리**
```java
@PostMapping("/register")
public String registerUser(@RequestBody User user) {
    return "Registered: " + user.getName();
}
```
- **JSON 요청 예시**:
```json
{
  "name": "Alice",
  "email": "alice@example.com"
}
```
- **`@RequestBody`**: 요청 본문에 담긴 JSON 데이터를 자바 객체로 매핑

##### 3. **헤더 데이터 처리**
```java
@PostMapping("/headers")
public String handleHeaders(@RequestHeader("Authorization") String token) {
    return "Token: " + token;
}
```
- 클라이언트가 전송한 헤더 값(`Authorization`)을 받아 처리.

---

### 사용 이유

1. **HTTP POST 요청 처리**
    
    - 데이터를 서버로 안전하게 전송하거나 리소스를 생성하는 데 사용됩니다.
    - 예: 사용자 등록, 파일 업로드 등.
2. **RESTful API 설계**
    
    - POST 요청은 **Create (생성)** 작업에 사용되며, RESTful API에서 필수적인 메서드입니다.
3. **가독성과 유지보수성 향상**
    
    - 직관적인 어노테이션 이름으로 코드 이해가 쉽고 유지보수가 용이합니다.

---

### 비교: `@RequestMapping`과 `@PostMapping`
```java
@RequestMapping(value = "/create", method = RequestMethod.POST)
```
- 동일한 기능을 하지만 더 길고 가독성이 떨어집니다.
```java
@PostMapping("/create")
```
- 간결하고 직관
---
### 결론

`@PostMapping`은 Spring MVC에서 POST 요청을 처리하기 위한 어노테이션으로, RESTful 서비스에서 데이터를 생성하거나 처리하는 데 가장 자주 사용됩니다. 데이터 입력, 생성, 업로드 등의 작업에서 유용하게 활용됩니다.