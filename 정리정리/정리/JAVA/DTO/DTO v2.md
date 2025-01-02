### **DTO (Data Transfer Object)**
**DTO**는 **Data Transfer Object**의 약자로, **데이터를 전송하기 위한 객체**입니다.  
주로 **계층 간 데이터 교환**을 단순화하고 효율적으로 수행하기 위해 사용됩니다.

---
### **DTO의 특징**
1. **데이터 전달 전용 객체**
    - 비즈니스 로직이 포함되지 않으며, 데이터를 단순히 담아 전달하는 역할을 합니다.
2. **Immutable 또는 Mutable**
    - 보통 데이터를 안전하게 다루기 위해 불변 객체(Immutable)로 설계되거나, 필요에 따라 값을 변경할 수 있게 Mutable로 설계됩니다.
3. **직렬화 가능**
    - 네트워크나 파일 시스템에서 데이터를 전송하거나 저장하려면 직렬화(Serialization)가 필요하며, DTO는 이를 지원합니다.

---

### **DTO 사용 이유**
1. **계층 간 데이터 교환 단순화**
    - 예: 컨트롤러 <-> 서비스, 서비스 <-> 데이터베이스 간 데이터를 전달하기 위해 DTO를 사용합니다.
2. **엔티티 보호**
    - 데이터베이스와 직접 연관된 **엔티티(Entity)**를 외부에 노출하지 않음으로써 보안 및 데이터 무결성을 유지할 수 있습니다.
3. **네트워크 트래픽 절감**
    - 필요한 데이터만 포함하도록 설계하여 네트워크 전송 비용을 줄입니다.
4. **유연성**
    - API 요구사항에 맞춰 데이터 구조를 자유롭게 설계할 수 있습니다.

---

### **DTO 예제**

#### 1. **엔티티 클래스**
- 데이터베이스와 매핑되는 클래스.
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password; // 민감 정보

    // getters, setters, etc.
}

```
#### 2. **DTO 클래스**
- 엔티티와 달리 민감 정보를 제외하고 필요한 데이터만 포함.
```java
public class UserDTO {
    private String name;
    private String email;

    // 생성자
    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
}
```
#### 3. **사용 예시**
- **서비스 계층에서 DTO로 변환**  
    서비스 계층에서 엔티티를 DTO로 변환하여 컨트롤러로 전달.
```java
@Service
public class UserService {
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDTO(user.getName(), user.getEmail());
    }
}
```
- 컨트롤러 계층에서 DTO 반환
```java
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
```

---
### **DTO vs. VO vs. Entity**

|**특징**|**DTO**|**VO (Value Object)**|**Entity**|
|---|---|---|---|
|**목적**|데이터 전송|값 객체 (불변, 의미 표현)|데이터베이스 매핑|
|**가변성**|Mutable/Immutable|Immutable|Mutable|
|**사용 범위**|계층 간 데이터 전송|비즈니스 로직에서 값 표현|데이터베이스와 직접 매핑|
|**직렬화 여부**|가능|가능|가능|
|**속성 포함 여부**|필요한 속성만 포함|의미 있는 값만 포함|데이터베이스와 1:1 매핑|

---
### **DTO 활용 시 유의사항**

1. **DTO 설계의 복잡성**
    - 데이터 요구사항에 따라 DTO를 설계하는 데 시간이 소요될 수 있습니다.
2. **DTO-엔티티 변환 로직**
    - DTO와 엔티티 간 변환은 수작업으로 구현하거나, **ModelMapper** 또는 **MapStruct** 같은 라이브러리를 사용할 수 있습니다.

---
### **요약**
- DTO는 계층 간 데이터를 효율적으로 전달하기 위해 설계된 객체입니다.
- 데이터를 단순화하여 엔티티를 보호하고, 필요한 데이터만 포함하여 전송 효율성을 높입니다.
- Spring 애플리케이션에서 컨트롤러와 서비스 간 또는 외부 API와의 통신에 널리 사용됩니다.