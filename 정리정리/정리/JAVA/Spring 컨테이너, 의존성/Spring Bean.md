
# Spring Bean
- 스프링(SPRING)에서 "빈(Bean)"은 **스프링 컨테이너에 의해 생성되고 관리되는 객체**를 의미합니다. 
- 스프링 프레임워크는 애플리케이션의 객체(Bean)들을 생성, 관리, 소멸시키는 역할을 하는 **IoC(제어의 역전) 컨테이너**를 제공합니다.
### 핵심 개념
1. **빈의 정의**
    - 스프링 애플리케이션에서 사용할 객체를 "빈"이라고 부릅니다.
    - 일반적으로 클래스의 인스턴스가 빈으로 등록됩니다.
2. **빈의 생명 주기**
    - 빈은 스프링 컨테이너가 관리합니다.
    - 객체 생성부터 의존성 주입, 초기화, 사용, 소멸까지의 과정을 스프링 컨테이너가 책임집니다.
3. **빈의 등록**
    - 빈은 스프링 컨테이너에 등록되어야 사용 가능합니다.
    - 등록 방법:
        - **XML 설정 파일**: `<bean>` 태그로 등록.
        - **Java Config 클래스**: `@Bean` 애노테이션 사용.
        - **컴포넌트 스캔**: `@Component`, `@Service`, `@Repository`, `@Controller` 등의 애노테이션 사용.
4. **빈의 관리**
    - 빈은 주로 다음과 같은 기능을 제공합니다:
        - **의존성 주입(DI)**: 빈 간의 의존 관계를 설정하고 주입.
        - **스코프**: 빈의 범위를 설정. (예: `singleton`, `prototype`, `request`, `session` 등)
        - **라이프사이클 콜백**: 빈 생성 시 초기화 작업이나 소멸 전에 정리 작업 실행 가능.

---

### 빈의 예제

#### 1. **Java Config 방식**
```java
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```
#### 2. **컴포넌트 스캔 방식**
```java
@Component
public class MyService {
    public void doSomething() {
        System.out.println("Hello, Spring Bean!");
    }
}
```
#### 3. **XML 설정 방식**
```xml
<beans>
    <bean id="myService" class="com.example.MyService"/>
</beans>
```
---
### 빈의 스코프
스프링에서 빈은 다양한 스코프를 가질 수 있습니다:
1. **singleton** (기본값): 스프링 컨테이너 당 하나의 인스턴스.
2. **prototype**: 요청할 때마다 새로운 인스턴스 생성.
3. **request**: HTTP 요청당 하나의 빈 인스턴스.
4. **session**: HTTP 세션당 하나의 빈 인스턴스.
5. **application**: 애플리케이션의 서블릿 컨텍스트당 하나의 인스턴스.

스프링에서 **빈(Bean)**을 사용하는 이유는 객체를 관리하고 애플리케이션의 의존성을 효율적으로 처리하기 위해서입니다. 이를 통해 개발자는 객체 생성, 의존성 주입, 생명 주기 관리 등을 스프링 프레임워크에 위임할 수 있으며, 다음과 같은 이점을 얻을 수 있습니다.

---

### **빈을 사용하는 이유**
#### 1. **의존성 관리와 DI(Dependency Injection)**
- **문제**: 객체 간의 의존성을 직접 코드에서 생성하면, 코드가 복잡해지고 유지보수가 어려워짐.
- **해결**: 빈과 DI를 사용하면 스프링 컨테이너가 객체를 생성하고 필요한 의존성을 주입해줌.
    - **예시**: 객체 A가 객체 B를 필요로 할 때, 스프링 컨테이너가 B를 생성해서 A에 전달.

```java
@Component
public class ServiceA {
    private final ServiceB serviceB;

    @Autowired
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB; // 의존성을 스프링이 주입
    }
}

```
---

#### 2. **객체의 생명 주기 관리**

- **문제**: 객체를 생성하고 소멸시키는 로직을 개발자가 직접 작성하면 복잡성이 증가.
- **해결**: 스프링 컨테이너가 객체의 생명 주기를 관리해 개발자는 로직 구현에만 집중 가능.
    - 초기화 메서드나 종료 메서드 지정 가능.
```java
@Bean(initMethod = "init", destroyMethod = "cleanup")
public MyService myService() {
    return new MyService();
}
```
---

#### 3. **애플리케이션 전역에서의 객체 공유**
- **문제**: 동일한 객체를 여러 곳에서 사용해야 할 때 매번 생성하면 비효율적.
- **해결**: 스프링 빈은 기본적으로 **싱글톤(Singleton)** 스코프를 사용해 한 번 생성된 객체를 재사용.
    - 필요에 따라 요청 스코프, 세션 스코프 등도 지원.

---

#### 4. **코드의 결합도 감소 (Low Coupling)**

- **문제**: 객체가 다른 객체에 강하게 의존하면 코드 변경 시 영향이 큼.
- **해결**: 스프링은 인터페이스를 기반으로 DI를 수행해 코드 간 결합도를 낮춤.
    - 새로운 구현체로 쉽게 교체 가능.

```java
public interface PaymentService {
    void pay();
}

@Component
public class CreditCardPaymentService implements PaymentService {
    public void pay() {
        System.out.println("Paid with credit card.");
    }
}
```

---

#### 5. **테스트 용이성**

- **문제**: 객체 간 의존 관계가 복잡할수록 단위 테스트가 어려움.
- **해결**: 빈과 DI를 사용하면 **Mock 객체**나 테스트용 빈을 쉽게 주입해 테스트 가능.

```java
@Test
public void testServiceA() {
    ServiceB mockServiceB = Mockito.mock(ServiceB.class);
    ServiceA serviceA = new ServiceA(mockServiceB);
    // 테스트 실행
}

```

---

#### 6. **구성 관리의 일원화**

- **문제**: 객체를 생성하는 코드가 여기저기 흩어져 있으면 유지보수가 어려움.
- **해결**: 모든 객체 생성과 관리를 스프링 컨테이너에서 일원화하여, 설정 파일 또는 애노테이션으로 관리.

---

#### 7. **코드 재사용과 유지보수성 증가**

- 빈을 사용하면 객체를 재사용하거나 교체할 때 코드 수정 없이 설정 변경만으로 처리 가능.
- 객체의 상태나 의존성을 스프링 컨테이너가 책임지기 때문에 개발자는 비즈니스 로직 구현에 집중할 수 있음.

---

### **결론**

스프링 빈은 **객체 관리의 복잡성을 줄이고**, **유지보수성과 확장성을 높이며**, **개발자의 생산성을 향상**시키는 도구입니다. 특히 **의존성 주입**과 **생명 주기 관리**를 통해 코드 품질과 테스트 용이성을 크게 개선합니다.

