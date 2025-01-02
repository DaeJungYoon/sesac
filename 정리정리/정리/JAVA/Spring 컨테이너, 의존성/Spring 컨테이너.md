스프링 컨테이너(Spring Container)는 **스프링 프레임워크의 핵심 구성 요소**로, **애플리케이션에서 사용하는 객체(빈, Bean)를 생성하고 관리하며 의존성을 주입(DI)**하는 역할을 담당합니다.

쉽게 말해, **스프링 애플리케이션의 객체(factory)**를 관리하는 공장이자 중재자입니다.

---

### **스프링 컨테이너의 역할**
1. **빈 관리**
    - 객체를 생성하고 초기화하며 소멸시키는 생명 주기를 관리.
    - 애플리케이션에서 필요한 빈을 스프링 컨테이너에 등록하고 필요할 때 제공.
2. **의존성 주입(DI)**
    - 빈 간의 의존 관계를 설정하고 객체 간의 결합도를 낮춤.
3. **구성 관리**
    - 객체의 생성, 초기화, 프로퍼티 설정 등을 통합 관리.
    - 개발자는 객체 생성/관리를 걱정하지 않고 비즈니스 로직에 집중할 수 있음.
4. **객체 재사용**
    - **싱글톤** 스코프를 사용해 메모리 사용량을 줄이고 성능을 최적화.
5. **다양한 설정 방식 지원**
    - XML, Java Config, 애노테이션 등 다양한 방식으로 설정 가능.

---

### **스프링 컨테이너의 종류**
스프링 컨테이너는 다양한 유형이 있으며, 주로 두 가지 인터페이스를 구현합니다:
#### 1. **BeanFactory**
- 가장 기본적인 스프링 컨테이너.
- 객체의 지연 초기화(Lazy Initialization)를 지원하여 성능 최적화 가능.
- 예: `XmlBeanFactory` (스프링 3.1 이후 거의 사용되지 않음)

#### 2. **ApplicationContext**
- BeanFactory를 확장한 고급 컨테이너.
- 애플리케이션 전반에 걸친 기능을 제공.
- 주요 특징:
    - **이벤트 발행 및 리스닝** 기능 제공.
    - 국제화(Internationalization) 지원.
    - 애노테이션 기반 구성 및 AOP 통합 지원.
    - 기본적으로 **즉시 초기화(Eager Initialization)**를 사용.
- 구현체 예:
    - `ClassPathXmlApplicationContext` (XML 파일 사용)
    - `AnnotationConfigApplicationContext` (Java Config 사용)
    - `WebApplicationContext` (웹 애플리케이션용)

---

### **스프링 컨테이너의 동작 원리**

1. **구성 파일 읽기**
    - XML, Java Config, 애노테이션 기반 설정 파일을 읽음.
    - 예: `applicationContext.xml`, `@Configuration` 클래스.
2. **빈 등록**
    - 설정 파일에 정의된 빈 정보를 기반으로 빈을 컨테이너에 등록.
3. **빈 생성**
    - 빈이 필요한 시점에 스프링 컨테이너가 객체를 생성.
    - 기본적으로 **싱글톤(Singleton) 스코프**로 관리.
4. **의존성 주입**
    - 빈 간의 의존 관계를 설정하고 필요한 의존성을 주입.
5. **빈 제공**
    - 개발자가 요청하면 해당 빈을 제공.
6. **빈의 생명 주기 관리**
    - 생성 -> 초기화 -> 사용 -> 소멸까지 컨테이너가 책임짐.

---

### **스프링 컨테이너의 예제**

#### 1. **XML 기반 컨테이너**
```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
MyService myService = context.getBean("myService", MyService.class);
myService.doSomething();
```
#### 2. **Java Config 기반 컨테이너**
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}

ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
MyService myService = context.getBean(MyService.class);
myService.doSomething();
```
#### 3. **애노테이션 기반 컨테이너**
```java
@Component
public class MyService {
    public void doSomething() {
        System.out.println("Hello, Spring Container!");
    }
}

ApplicationContext context = new AnnotationConfigApplicationContext("com.example");
MyService myService = context.getBean(MyService.class);
myService.doSomething();
```
### **왜 스프링 컨테이너를 사용하는가?**

1. **객체 관리 자동화**: 객체 생성, 의존성 주입, 생명 주기를 자동으로 관리.
2. **유지보수성 향상**: 객체 간 결합도를 낮춰 코드 변경의 영향을 최소화.
3. **구성 일원화**: 객체 관리와 설정을 통합하여 일관된 애플리케이션 설계 가능.
4. **코드 단순화**: 개발자는 로직 구현에만 집중할 수 있음.

---

스프링 컨테이너는 스프링 프레임워크의 핵심으로, 객체 관리의 복잡성을 크게 줄이고 애플리케이션 개발 생산성을 높이는 중요한 도구입니다.
