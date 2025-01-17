# @Service
- `@Service`는 **Spring Framework**에서 제공하는 어노테이션으로, 서비스 계층을 나타내는 데 사용됩니다. 
- 이 어노테이션은 클래스가 비즈니스 로직을 수행하는 역할임을 명시적으로 알려줍니다.

---
### **특징**

1. **서비스 계층 정의**
    - 애플리케이션의 **서비스 계층**을 구현하는 클래스에 붙입니다.
    - 서비스 계층은 비즈니스 로직을 포함하고, 컨트롤러와 데이터 접근 계층(Repository) 사이에서 중재 역할을 합니다.
2. **컴포넌트 스캔 대상**
    - `@Service`는 **스프링 컨텍스트**에서 자동으로 **빈(Bean)**으로 등록됩니다.
    - `@Component`와 동일한 기능을 하며, 단지 **서비스 계층의 역할**을 더 명확히 표현하기 위해 사용됩니다.
3. **의존성 주입 대상**
    - `@Service`로 등록된 클래스는 다른 곳에서 `@Autowired`나 **생성자 주입**으로 주입받아 사용할 수 있습니다.

---
### **장점**

- **의미 명확화**
    - 클래스가 **서비스 계층**임을 코드로 명시하여 가독성을 높입니다.
- **비즈니스 로직 캡슐화**
    - 컨트롤러와 레포지토리 간의 복잡한 로직을 한 곳에 집중시켜 관리합니다.
- **스프링의 DI(의존성 주입) 지원**
    - 스프링이 관리하는 Bean으로 등록되므로, 의존성 관리가 용이합니다.

---
### **예제**

#### 1. 기본 사용
```java
@Service
public class UserService {

    public String getUserName() {
        return "Alice";
    }
}
```
#### 2. 다른 클래스에서 주입받기
```java
@RestController
public class UserController {

    private final UserService userService;

    // 생성자 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/username")
    public String getUserName() {
        return userService.getUserName(); // UserService의 메서드 호출
    }
}
```
---
### **서비스 계층의 역할**

- **컨트롤러**와 **레포지토리** 간의 **중재자** 역할을 수행합니다.
- 비즈니스 로직, 트랜잭션 처리 등을 포함합니다.

#### 3계층 구조 예시

1. **컨트롤러 계층** (`@RestController`)
    - 사용자 요청을 처리하고 응답을 반환합니다.
2. **서비스 계층** (`@Service`)
    - 비즈니스 로직을 수행하며, 필요한 경우 여러 레포지토리와 상호작용합니다.
3. **데이터 접근 계층** (`@Repository`)
    - 데이터베이스와 직접적으로 상호작용하여 데이터를 저장하거나 조회합니다.

---
### **참고**

`@Service`는 역할을 명시적으로 표현하기 위한 어노테이션입니다. 내부적으로는 `@Component`와 동일한 동작을 하지만, 코드의 **가독성**과 **의미**를 명확히 하기 위해 사용됩니다.

- 다른 역할의 어노테이션:
    - `@Controller`: 컨트롤러 역할
    - `@Repository`: 데이터 접근 계층 역할
    - `@Component`: 범용 컴포넌트 역할