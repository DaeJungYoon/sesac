# @PathVariable
- Spring Framework에서 사용되는 어노테이션으로, URL 경로의 일부를 메서드의 파라미터로 매핑할 때 사용됩니다. 
- RESTful 웹 서비스에서 동적인 URL 경로를 처리하기 위해 자주 사용됩니다.

예를 들어, 다음과 같은 URL 경로가 있다고 가정합니다:

```bash
/users/123
```

여기서 `123`은 동적으로 변할 수 있는 값입니다. 이를 처리하기 위해 `@PathVariable`을 사용하여 해당 값을 메서드 파라미터로 매핑할 수 있습니다.

### 예제 코드
```java
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") String userId) {
        return "User ID: " + userId;
    }
}

```

### 설명

1. **`@PathVariable("id")`**
    - URL 경로에서 `{id}` 부분을 `userId` 파라미터로 매핑합니다.
    - `"id"`는 URL 템플릿 변수의 이름을 나타냅니다.
2. **동작**:
    - 사용자가 `/users/123`로 요청을 보내면, `123`이 `userId`에 매핑됩니다.
    - 반환 값은 `"User ID: 123"`이 됩니다.
3. **생략 가능**:
    - 만약 `@PathVariable`의 이름과 메서드 파라미터 이름이 동일하다면, `"id"`를 생략할 수 있습니다:
```java
@GetMapping("/{id}")
public String getUserById(@PathVariable String id) {
    return "User ID: " + id;
}
```
    
        

### 여러 개의 `@PathVariable` 사용
경로에 여러 동적인 값을 포함할 수도 있습니다:
```java
@GetMapping("/{userId}/orders/{orderId}")
public String getOrder(@PathVariable String userId, @PathVariable String orderId) {
    return "User ID: " + userId + ", Order ID: " + orderId;
}
```

- 요청: `/users/123/orders/456`
- 출력: `User ID: 123, Order ID: 456`

### 장점
- URL 경로를 직관적으로 표현할 수 있어 RESTful API 설계에 적합합니다.
- 코드 가독성이 좋아지고, 동적인 URL 처리가 쉬워집니다.