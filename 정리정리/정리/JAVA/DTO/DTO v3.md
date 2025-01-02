### **DTO (Data Transfer Object) 정리본**

#### **DTO란?**
DTO는 **Data Transfer Object**의 약자로, **계층 간 데이터 전달을 위한 객체**입니다. 데이터를 단순히 전달하는 역할을 하며, 주로 **컨트롤러와 서비스 계층**, 혹은 **클라이언트와 서버 간**의 데이터 교환을 단순화하고 효율적으로 수행하기 위해 사용됩니다.

---

#### **DTO를 사용하는 이유**
1. **엔티티(Entity) 보호**
    - 데이터베이스와 직접 연관된 엔티티를 외부에 노출하지 않음으로써 보안 및 데이터 무결성을 유지.
2. **API 스펙 보호**
    - 도메인 모델의 변경으로부터 API 스펙을 분리하고 안정성을 보장.
3. **네트워크 트래픽 절감**
    - 필요한 데이터만 포함해 전송 비용을 줄임.
4. **순환 참조 문제 방지**
    - 양방향 연관 관계로 인해 발생할 수 있는 순환 참조 문제를 방지.
5. **유연한 데이터 구조 제공**
    - API 요구사항에 맞춘 맞춤형 데이터 구조 설계 가능.

---

#### **Entity vs DTO**

| **특징**     | **Entity**            | **DTO**              |
| ---------- | --------------------- | -------------------- |
| **목적**     | 데이터베이스 매핑             | 데이터 전달 전용            |
| **역할**     | 데이터의 영속성 관리           | 계층 간 데이터 전달          |
| **내용 포함**  | 데이터베이스 관련 정보와 비즈니스 로직 | 필요한 데이터만 포함          |
| **가변성**    | Mutable               | Mutable 또는 Immutable |
| **직렬화 여부** | 가능                    | 가능                   |

---
#### **DTO의 종류**
1. **Request DTO**
    - 클라이언트에서 서버로 데이터를 전달할 때 사용.
    - 주로 `@RequestBody`와 함께 사용되며 데이터 유효성 검증 어노테이션 포함.
    - `@NoArgsConstructor` 필요.
2. **Response DTO**
    - 서버에서 클라이언트로 데이터를 반환할 때 사용.
    - 민감한 정보를 제외하고 필요한 정보만 포함.
    - 여러 엔티티 데이터를 조합하여 반환 가능.
    - 데이터 안전성을 위해 `final` 필드를 자주 사용.

---

#### **DTO 작성 방법**
1. **Builder 패턴**
    - 복잡한 객체 생성 과정을 단순화하고 선택적 매개변수를 쉽게 처리.
    - `Lombok`의 `@Builder`를 사용하여 코드 가독성 향상.
```java
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
    private String name;
    private String email;
}

// 사용법
User user = User.builder()
    .name("이름")
    .email("이메일")
    .build();

```
- **특징**
    - 복잡한 객체 생성 과정을 단순화하여 가독성을 높임.
    - 선택적 매개변수 처리가 용이하며, 필수값과 선택값을 명확히 구분 가능.
    - 각 매개변수의 의미를 명확히 표현할 수 있어, 코드의 유지보수성이 향상됨.
    - `Lombok`의 `@Builder`를 사용하여 손쉽게 구현 가능.
- **장점**
    - **가독성**  
	    생성 시 각 필드가 어떤 값을 의미하는지 명확히 알 수 있음.
    - **안정성**
	    - 객체 생성 시 필요한 필드만 설정하여 불완전한 객체 생성을 방지.
	    - `Immutable` 객체를 쉽게 설계할 수 있음.
	- **유연성**
	    - 필수 필드와 선택적 필드를 쉽게 구분.
	    - 필요에 따라 빌더 메서드를 추가해 다양한 생성 요구사항을 처리 가능.

2. **정적 팩토리 메서드 패턴**
    
    - 객체 생성을 캡슐화하며, 명확한 메서드 이름으로 의도를 표현.
    - 추가적인 검증 및 데이터 변환 로직을 포함 가능.
```java
@Getter
@Builder
public class UserResponseDto {
    private final Long id;
    private final String name;
    private final String email;

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .build();
    }
}

// 사용법
UserResponseDto dto = UserResponseDto.from(user);
```
- **특징**
    - 객체 생성 로직을 캡슐화하며, `static` 메서드를 통해 객체 생성.
    - 생성자 대신 이름이 명확한 메서드(`from()`, `of()`, `valueOf()`)로 의도를 표현.
    - 데이터 변환, 검증, 추가 로직 등을 객체 생성 시점에 포함할 수 있음.
    - 불완전한 객체 생성을 방지하며, 캐싱이나 객체 풀링을 지원 가능.
- **장점**
    - **의도 표현**  
	    - 메서드 이름을 통해 객체 생성의 목적을 명확히 전달 가능.
		    - 예)`from()` , `of()`
    - **객체 생성의 캡슐화**
	    - 생성자를 노출하지 않아 객체 생성 로직을 한곳에 집중.
	    - 생성 시 필요한 검증 로직이나 추가 작업을 포함 가능.
		    - DTO를 생성하는 과정에서 추가적인 검증이나 데이터 변환 로직이 필요한 
	          경우 생성자 대신 팩토리 메서드에 로직을 넣을 수 있다.
        - 호출할 때마다 새로운 객체를 생성할 필요가 없다. (캐싱, 객체 풀링 등 가능)
	- **객체 생성의 유연성**
	    - 생성 시 하위 클래스나 변형된 객체 반환 가능.
	    - 예: 같은 데이터로 API 요청/응답 요구사항에 맞는 DTO 반환
		    -  예) `결제` 객체에 대한 생성을 하였을 때 `OO결제` 인스턴스 반환.
		- 정적 팩토리 메서드 패턴의 **객체 생성의 유연성**은 다양한 객체를 **상황에 따라 적합하게 생성**할 수 있다는 점에서 오는 특징입니다. 아래에서 더 구체적으로 설명하겠습니다.
1. **이름을 가진 메서드로 목적을 명확히 표현 가능**
    - 생성자는 이름을 가질 수 없지만, 정적 팩토리 메서드는 이름을 가질 수 있습니다.
    - 같은 클래스에서 **다양한 의도**로 객체를 생성할 때 메서드 이름으로 목적을 표현할 수 있습니다.
    - 예:
	```java
	public class User {
	    private String name;
	    private String email;
	
	    private User(String name, String email) {
	        this.name = name;
	        this.email = email;
	    }
	
	    // 정적 팩토리 메서드
	    public static User fromName(String name) {
	        return new User(name, null);
	    }
	
	    public static User fromEmail(String email) {
	        return new User(null, email);
	    }
	}
	```
- `fromName()`은 이름 기반으로, `fromEmail()`은 이메일 기반으로 객체를 생성.
- 이렇게 메서드 이름으로 객체 생성 의도를 명확히 표현 가능.
---

2. **다른 자료형 객체를 반환 가능**
    - 정적 팩토리 메서드는 반환 타입으로 반드시 자기 자신의 클래스일 필요가 없습니다.
    - **상위 클래스나 인터페이스를 반환**하고, 실제 구현은 상황에 따라 달라질 수 있습니다.
    - 예:
	```java
	public interface Payment {
	    void pay();
	}
	
	public class CreditCardPayment implements Payment {
	    @Override
	    public void pay() {
	        System.out.println("Paying with Credit Card");
	    }
	}
	
	public class PayPalPayment implements Payment {
	    @Override
	    public void pay() {
	        System.out.println("Paying with PayPal");
	    }
	}
	
	public class PaymentFactory {
	    public static Payment createPayment(String type) {
	        if (type.equalsIgnoreCase("credit")) {
	            return new CreditCardPayment();
	        } else if (type.equalsIgnoreCase("paypal")) {
	            return new PayPalPayment();
	        }
	        throw new IllegalArgumentException("Unknown payment type");
	    }
	}
	
	public class Main {
	    public static void main(String[] args) {
	        Payment payment = PaymentFactory.createPayment("credit");
	        payment.pay(); // Output: Paying with Credit Card
	    }
	}
	```
 - `PaymentFactory.createPayment()`은 `Payment` 인터페이스를 반환하지만, 실제로는 상황에 따라 `CreditCardPayment`나 `PayPalPayment` 객체를 생성합니다.
- 이 유연성 덕분에 클라이언트 코드는 구현 세부 사항을 알 필요가 없습니다.

---

3. **추가 로직이나 변환을 포함한 객체 생성**
    - 정적 팩토리 메서드는 단순히 객체를 생성하는 데 그치지 않고, 생성 과정에서 추가적인 로직을 수행하거나 데이터를 변환할 수 있습니다.
        
    - 예:
	```java
	public class User {
	    private String username;
	    private int age;
	
	    private User(String username, int age) {
	        this.username = username;
	        this.age = age;
	    }
	
	    public static User from(String username, String ageString) {
	        int age = Integer.parseInt(ageString); // 문자열을 정수로 변환
	        if (age < 0) {
	            throw new IllegalArgumentException("Age cannot be negative");
	        }
	        return new User(username, age);
	    } 
	}

	public class Main {
	    public static void main(String[] args) {
	        User user = User.from("Alice", "25");
	        // 정적 팩토리 메서드 내에서 age 변환 및 검증 로직 수행
	    }
	}       
	```
- `User.from()`에서 문자열 `ageString`을 정수로 변환하고, 음수 값인지 검증한 뒤 객체를 생성합니다.
- 이런 유연한 생성 로직은 정적 팩토리 메서드만이 제공할 수 있습니다.

---

### **장점 요약**
- **다양한 객체 생성 방식 제공**: 상황에 따라 적합한 객체를 반환 가능 (예: 다형성 활용).
- **명확한 의도 표현**: 메서드 이름으로 객체 생성 목적을 쉽게 이해할 수 있음.
- **추가 로직 포함 가능**: 생성자에서는 할 수 없는 데이터 검증이나 변환 같은 로직을 포함 가능.

이 모든 것이 **객체 생성의 유연성**으로 설명됩니다. 이해되었나요? 😊
	- **무결성 보장**
	    - 생성자를 `private`으로 지정해 잘못된 상태로 객체 생성이 방지됨.
	    - DTO 내부의 로직으로 안전하고 일관된 객체를 생성.
	    - 객체 생성 시점에 추가적인 검증 로직을 수행할 수 있다.
---

#### **DTO 활용 시 주의사항**
1. **DTO와 엔티티 간 변환**
    - DTO와 엔티티 간 변환 로직은 수작업으로 구현하거나 `ModelMapper`, `MapStruct` 같은 라이브러리를 활용.
2. **복잡한 설계**
    - 데이터 요구사항에 맞춰 DTO를 설계하는 데 시간이 소요될 수 있음.
3. **객체 불변성 유지**
    - 가능하면 Immutable 객체로 설계하여 데이터 무결성을 보장.

---
#### **요약**
DTO는 데이터를 단순히 전달하기 위한 객체로, 엔티티와 분리하여 계층 간 데이터를 안전하고 효율적으로 교환할 수 있도록 설계됩니다. 이를 통해 보안, 유연성, 네트워크 효율성을 모두 개선할 수 있습니다. `Builder 패턴`과 `정적 팩토리 메서드`는 DTO 설계와 활용에서 자주 사용하는 접근 방식입니다.
- **Builder 패턴**은 복잡한 객체를 명확하고 직관적으로 생성할 수 있어, 가독성이 중요한 경우 유용합니다. 특히 필수값과 선택값을 쉽게 처리할 수 있습니다.
- **정적 팩토리 메서드**는 객체 생성 로직을 캡슐화하고, 추가 검증과 데이터 변환 로직을 포함하기에 적합합니다. 명확한 메서드 이름으로 의도를 전달하며, 다양한 생성 요구사항을 처리할 수 있습니다.