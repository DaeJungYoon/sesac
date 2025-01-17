# @Transactional 
- `@Transactional`은 **Spring Framework**에서 제공하는 어노테이션으로, **트랜잭션 관리**를 위한 기능을 제공합니다. 
- 데이터베이스 작업(예: 삽입, 수정, 삭제)에서 **데이터의 일관성과 무결성**을 보장하기 위해 사용됩니다.

---
### **트랜잭션이란?**
- 데이터베이스에서 **일련의 작업들을 하나의 단위로 묶는 것**을 의미합니다.
- 트랜잭션은 아래의 **ACID** 특성을 만족해야 합니다:
    1. **Atomicity (원자성)**: 모든 작업이 완전히 실행되거나, 전혀 실행되지 않아야 합니다.
    2. **Consistency (일관성)**: 트랜잭션 전후 데이터의 무결성이 유지되어야 합니다.
    3. **Isolation (고립성)**: 동시에 실행되는 트랜잭션들이 서로 간섭하지 않아야 합니다.
    4. **Durability (지속성)**: 트랜잭션이 성공적으로 완료되면 결과가 영구적으로 저장되어야 합니다.

---
### **@Transactional의 주요 기능**

1. **자동 커밋 제어**
    - 트랜잭션 범위 내의 작업이 성공하면 **커밋**(Commit)되고, 실패하면 **롤백**(Rollback)됩니다.
2. **예외 발생 시 롤백**
    - 기본적으로 **unchecked 예외**(`RuntimeException`과 그 하위 예외) 발생 시 트랜잭션을 롤백합니다.
    - **checked 예외**는 롤백되지 않으며, 이를 롤백하려면 `rollbackFor` 속성을 사용해야 합니다.
3. **읽기 전용 트랜잭션 설정**
    - `readOnly = true`로 설정하면 데이터를 변경하지 않는 읽기 전용 작업으로 최적화할 수 있습니다.
4. **트랜잭션 전파 설정**    
    - `propagation` 속성을 통해 트랜잭션 전파(Propagation) 방식을 설정할 수 있습니다.
5. **격리 수준 설정**
    - `isolation` 속성을 통해 데이터의 **격리 수준**을 설정할 수 있습니다.

---

### **@Transactional 기본 사용법**

#### 1. 트랜잭션 적용
```java
@Service
public class UserService {

    @Transactional
    public void createUser(User user) {
        userRepository.save(user); // 데이터베이스 삽입
        // 다른 로직 수행
    }
}
```
#### 2. 읽기 전용 트랜잭션
```java
@Transactional(readOnly = true)
public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
}
```
#### 3. 특정 예외 롤백
```java
@Transactional(rollbackFor = Exception.class)
public void updateUser(User user) throws Exception {
    userRepository.save(user);
    if (someCondition) {
        throw new Exception("Something went wrong");
    }
}
```

---
### **트랜잭션 전파(Propagation)**
트랜잭션 전파는 하나의 트랜잭션이 다른 트랜잭션과 어떻게 상호작용할지를 정의합니다.  
주요 옵션:
- **REQUIRED (기본값)**: 현재 트랜잭션이 있으면 참여, 없으면 새로 시작.
- **REQUIRES_NEW**: 항상 새로운 트랜잭션 시작.
- **SUPPORTS**: 트랜잭션이 있으면 참여, 없으면 트랜잭션 없이 실행.
- **NOT_SUPPORTED**: 트랜잭션 없이 실행.
- **MANDATORY**: 반드시 기존 트랜잭션에 참여, 없으면 예외 발생.
- **NEVER**: 트랜잭션이 있으면 예외 발생.
- **NESTED**: 현재 트랜잭션 내에 중첩 트랜잭션 시작.

---

### **@Transactional의 주요 속성**

| **속성**            | **설명**                  |
| ----------------- | ----------------------- |
| **value**         | 트랜잭션 관리자를 지정합니다.        |
| **propagation**   | 트랜잭션 전파 방식을 지정합니다.      |
| **isolation**     | 트랜잭션의 격리 수준을 설정합니다.     |
| **readOnly**      | 읽기 전용 트랜잭션 여부를 설정합니다.   |
| **timeout**       | 트랜잭션 실행 시간 초과 제한(초 단위). |
| **rollbackFor**   | 롤백할 예외를 지정합니다.          |
| **noRollbackFor** | 롤백하지 않을 예외를 지정합니다.      |

---

### **트랜잭션 격리 수준**
데이터 일관성과 동시성 처리 방식을 설정:
1. **DEFAULT**: 데이터베이스의 기본 격리 수준 사용.
2. **READ_UNCOMMITTED**: 커밋되지 않은 데이터도 읽기 가능 (가장 낮은 격리).
3. **READ_COMMITTED**: 커밋된 데이터만 읽기 가능.
4. **REPEATABLE_READ**: 트랜잭션 내에서 동일한 데이터를 여러 번 읽어도 동일한 값 유지.
5. **SERIALIZABLE**: 가장 높은 격리 수준, 모든 트랜잭션이 순차적으로 실행.

---

### **장점**
- 데이터 무결성 보장.
- 개발자가 트랜잭션 관리 코드를 작성하지 않아도 됨.
- 비즈니스 로직에 집중할 수 있음.

---

### **주의사항**
1. **메서드가 public이어야 적용 가능**
    - Spring AOP 기반으로 동작하므로, private 메서드에는 적용되지 않습니다.
2. **프록시 객체를 통해 동작**
    - 동일 클래스의 내부 메서드 호출에는 트랜잭션이 적용되지 않을 수 있습니다.
3. **JPA와 함께 사용 시**
    - JPA는 영속성 컨텍스트와 밀접하게 연결되어 있으므로, 트랜잭션 종료 시점에 플러시됩니다.
    - 반드시 트랜잭션 내에서 JPA 작업을 수행해야 합니다.

---

`@Transactional`은 데이터베이스 작업에서 데이터를 안전하게 관리하는 데 필수적인 도구로, 올바른 설정과 이해를 통해 효율적으로 활용할 수 있습니다.