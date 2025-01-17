`@AuthenticationPrincipal`은 Spring Security에서 인증된 사용자의 정보를 컨트롤러 메서드에서 직접 가져올 수 있도록 도와주는 어노테이션입니다. 주로 컨트롤러에서 현재 인증된 사용자의 세부 정보를 처리할 때 사용됩니다.

### 주요 기능

- 현재 인증된 사용자의 세부 정보(`Principal`)를 메서드 파라미터로 바인딩합니다.
- 기본적으로 `SecurityContext`에 저장된 `Authentication` 객체의 `Principal` 값을 가져옵니다.

### 사용 예시

다음은 `@AuthenticationPrincipal`의 간단한 사용 예입니다:

#### 1. 인증된 사용자 정보 가져오기

```java
@RestController
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<String> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok("Hello, " + userDetails.getUsername());
    }
}
```

위 예제에서는 현재 인증된 사용자의 정보를 `UserDetails` 객체로 받아와 사용할 수 있습니다.

#### 2. 커스텀 유저 클래스 사용

만약 커스텀 `UserDetails` 클래스를 사용 중이라면, 해당 클래스를 그대로 받을 수 있습니다.

```java
@RestController
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<String> getCurrentUser(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return ResponseEntity.ok("Hello, " + customUserDetails.getName());
    }
}
```
#### 3. JSON 반환 예제
```java
@RestController
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<CustomUserDetails> getCurrentUser(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return ResponseEntity.ok(customUserDetails);
    }
}
```

### 내부 동작

- `@AuthenticationPrincipal`은 기본적으로 `SecurityContextHolder.getContext().getAuthentication().getPrincipal()`에서 `Principal` 값을 가져옵니다.
- `Principal` 값은 보통 `UserDetails` 객체이거나, JWT 기반 인증을 사용할 경우, JWT에 포함된 사용자 정보일 수 있습니다.

### 유용한 점

- 컨트롤러 메서드에서 인증된 사용자 정보를 간편하게 사용할 수 있어 코드의 가독성과 유지보수성이 향상됩니다.
- 불필요하게 `SecurityContextHolder`를 직접 참조하지 않아도 됩니다.

### 주의사항

- `Principal`이 반드시 `UserDetails` 타입이 아닐 수도 있습니다. 예를 들어, JWT 기반 인증을 사용할 경우 `String`이나 커스텀 타입일 수 있으므로 타입을 명확히 확인해야 합니다.