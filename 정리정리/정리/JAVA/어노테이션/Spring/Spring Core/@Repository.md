# @Repository
- `@Repository`는 **Spring Framework**에서 제공하는 어노테이션으로, **데이터 접근 계층(DAO, Data Access Object)**을 나타냅니다. 주로 데이터베이스와 상호작용하는 클래스에 사용됩니다.

---
### **@Repository의 주요 역할**
1. **DAO 역할 명시**
    - 클래스가 데이터베이스 작업(예: CRUD)을 수행하는 역할을 가지고 있음을 선언적으로 나타냅니다.
2. **Persistence Exception Translation**
    - Spring이 제공하는 예외 변환 메커니즘을 활성화합니다.
    - 데이터 접근 계층에서 발생하는 특정 데이터베이스 예외(예: `SQLException`)를 Spring의 공통 데이터 접근 예외로 변환합니다.
        - 예: `SQLException` → `DataAccessException`
3. **컴포넌트 스캔 대상**
    - `@Component`의 특수화로, Spring이 해당 클래스를 **빈(bean)**으로 자동 등록합니다.

---

### **사용법**
#### 1. DAO 클래스 정의
```java
@Repository
public class UserRepository {
    // 데이터 접근 로직
    public User findById(Long id) {
        // 데이터베이스에서 사용자 조회
    }
}
```
#### 2. Spring Data JPA와 함께 사용
Spring Data JPA에서는 `@Repository`를 생략해도 자동으로 등록됩니다.
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 기본 CRUD 메서드 제공
    List<User> findByName(String name);
}
```
---

### **@Repository와 @Component의 관계**

- `@Repository`는 `@Component`의 세분화된 어노테이션 중 하나입니다.
    - `@Service`는 서비스 계층,
    - `@Controller`는 컨트롤러 계층,
    - `@Repository`는 데이터 접근 계층에 사용됩니다.
- `@Repository`는 단순히 빈으로 등록하는 것 외에도 **Persistence Exception Translation** 기능을 제공합니다.

---
### **Persistence Exception Translation**

Spring이 데이터 접근 계층에서 발생하는 특정 예외를 공통 예외로 변환합니다.  
예를 들어:
- `SQLException` → `DataAccessException`
- 데이터베이스 공급자에 따라 발생하는 예외를 통일된 형태로 처리할 수 있어 코드의 이식성이 향상됩니다.

---
### **@Repository의 주요 장점**

1. **역할 분리 명확화**
    - 데이터 접근 로직이 포함된 클래스를 명시적으로 나타냅니다.
2. **예외 처리 간소화**
    - 데이터 접근 예외를 Spring 공통 예외로 변환하여 처리 로직을 단순화합니다.
3. **Spring의 자동 빈 등록**    
    - 컴포넌트 스캔을 통해 애플리케이션 컨텍스트에 자동으로 등록됩니다.

---

### **예제: @Repository와 @Service 연동**
```java
@Repository
public class UserRepository {
    public User findById(Long id) {
        // DB에서 사용자 검색 로직
        return new User(id, "John Doe");
    }
}

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }
}
```
- `@Repository`는 데이터 접근 계층을 캡슐화하고 Spring과의 연동성을 높이는 데 핵심적인 역할을 합니다.