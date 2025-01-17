`AuthenticationManager`는 Spring Security에서 인증(Authentication)을 처리하는 중심적인 인터페이스입니다. 주로 애플리케이션의 보안 관련 로직에서 사용되며, 사용자의 자격 증명을 확인하고 인증을 수행하는 역할을 합니다.

---

## 주요 기능

`AuthenticationManager`는 인증을 처리하고, 이를 통해 애플리케이션이 사용자가 신뢰할 수 있는지 여부를 결정하도록 돕습니다.

### 메서드

`AuthenticationManager`는 단 하나의 메서드를 가지는 단순한 인터페이스입니다.

```java
Authentication authenticate(Authentication authentication) throws AuthenticationException;
```

- **매개변수:**
    - `Authentication authentication`: 사용자로부터 받은 인증 정보(예: 사용자 이름, 비밀번호, 토큰 등)를 포함합니다.
- **반환값:**
    - 인증이 성공하면, 인증된 `Authentication` 객체를 반환합니다. 이 객체는 사용자의 권한, 추가 정보 등을 포함합니다.
- **예외 처리:**
    - 인증 실패 시 `AuthenticationException`을 던집니다.

---

## 작동 방식

1. **사용자가 인증 요청**:
    
    - 사용자가 애플리케이션에 로그인하거나 액세스하려고 할 때 인증 정보(예: 사용자 이름과 비밀번호)를 보냅니다.
2. **`AuthenticationManager` 호출**:
    
    - `AuthenticationManager`는 이 정보를 기반으로 인증을 시도합니다.
3. **인증 프로세스**:
    
    - `AuthenticationManager`는 등록된 여러 `AuthenticationProvider` 중 적합한 것을 선택하여 인증을 처리합니다.
4. **결과 반환**:
    
    - 인증 성공: 인증된 `Authentication` 객체를 반환.
    - 인증 실패: 예외를 던짐.

---

## 구현

`AuthenticationManager`는 보통 직접 구현하지 않고, Spring Security가 제공하는 기본 구현체를 사용합니다.

### 가장 흔한 구현체: `ProviderManager`

- `ProviderManager`는 여러 `AuthenticationProvider`를 사용하여 인증을 위임합니다.
- 각각의 `AuthenticationProvider`는 특정 인증 메커니즘을 처리합니다. (예: 비밀번호 기반 인증, OAuth2, JWT 등)

```java
AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(new DaoAuthenticationProvider(), new JwtAuthenticationProvider()));
```

---

## 사용 예제

### 1. 사용자 정의 `AuthenticationManager` 생성

```java
@Bean
public AuthenticationManager customAuthenticationManager(AuthenticationProvider provider) {
    return new ProviderManager(Collections.singletonList(provider));
}
```

### 2. Spring Security 설정에서 사용

```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("user").password("{noop}password").roles("USER");
}
```

---

## 핵심 개념 요약

- **역할**: 인증 정보를 검증하고, 성공 여부를 반환.
- **구성 요소**: 여러 `AuthenticationProvider`와 함께 작동.
- **확장성**: 사용자 정의 인증 로직을 추가하거나, Spring Security에서 제공하는 다양한 인증 방법을 활용 가능.
