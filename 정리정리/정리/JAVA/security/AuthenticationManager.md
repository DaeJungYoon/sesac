`AuthenticationManager`는 일반적으로 **인증(Authentication)** 과정을 처리하는 역할을 하는 컴포넌트입니다. 주로 **Spring Security** 같은 프레임워크에서 사용됩니다. 인증된 사용자 정보를 확인하거나, 인증 실패 시 적절한 처리를 수행하는 데 사용됩니다.

---

### **Spring Security의 AuthenticationManager**

Spring Security에서 `AuthenticationManager`는 **사용자 인증 요청을 처리**하는 인터페이스입니다. 사용자가 제공한 인증 정보(예: 아이디와 비밀번호)가 올바른지 확인하고, 성공하면 인증된 사용자 정보를 반환합니다.

#### **주요 메서드**

- `authenticate(Authentication authentication)`:
    - 인증 요청을 받아서 처리합니다.
    - 인증이 성공하면 `Authentication` 객체를 반환하며, 실패하면 예외를 던집니다.

#### **구현 클래스**

Spring Security는 `AuthenticationManager`를 직접 구현하지 않고 보통 `ProviderManager`라는 구현체를 사용합니다.

---

### **AuthenticationManager의 동작 흐름**

1. **클라이언트 요청**:
    
    - 사용자가 로그인 폼을 통해 사용자 이름과 비밀번호를 보냅니다.
2. **Authentication 객체 생성**:
    
    - 로그인 요청 정보를 바탕으로 `UsernamePasswordAuthenticationToken` 같은 `Authentication` 객체가 생성됩니다.
3. **authenticate 호출**:
    
    - `AuthenticationManager`가 `authenticate()` 메서드를 호출하여 인증을 시도합니다.
    - 이 과정에서 하나 이상의 `AuthenticationProvider`를 사용해 인증을 위임합니다.
4. **인증 성공/실패**:
    
    - 성공하면 인증된 `Authentication` 객체가 반환되며, 보통 `SecurityContext`에 저장됩니다.
    - 실패하면 인증 관련 예외(`BadCredentialsException`, `LockedException` 등)가 발생합니다.

---

### **AuthenticationManager의 설정**

Spring Security 5 이상에서는 `SecurityFilterChain`과 함께 `AuthenticationManager`를 Java Config로 직접 설정하거나, `AuthenticationProvider`를 등록하여 사용할 수 있습니다.

#### 예제 코드 (Java Config)
```java
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
}

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeRequests(auth -> auth.anyRequest().authenticated())
        .formLogin(withDefaults())
        .build();
}

```

---

### **사용자 정의 AuthenticationManager**

필요에 따라 커스텀 인증 로직을 구현하려면 `AuthenticationManager`를 직접 구현하거나, 커스텀 `AuthenticationProvider`를 추가할 수 있습니다.

#### 예제: Custom AuthenticationProvider
```java
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("admin".equals(username) && "password".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }

        throw new BadCredentialsException("Invalid username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

```
---

### 요약

- `AuthenticationManager`는 사용자 인증 요청을 처리하는 핵심 인터페이스입니다.
- Spring Security에서 기본 구현은 `ProviderManager`이며, `AuthenticationProvider`를 통해 실제 인증 로직을 수행합니다.
- 커스텀 인증 로직이 필요하면 `AuthenticationProvider`를 구현하거나, 필요에 따라 직접 `AuthenticationManager`를 설정할 수 있습니다.
