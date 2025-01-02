# DI(Dependency Injection)
- 소프트웨어 디자인 패턴 중 하나로, 객체 간의 **의존성**을 외부에서 주입하는 방식입니다. 
- 이를 통해 코드의 **유연성**, **재사용성**, **테스트 용이성**을 높이는 데 기여합니다.
---
### **DI의 주요 개념**
1. **의존성 (Dependency)**
    - 클래스가 다른 클래스나 객체를 사용하는 관계.
    - 예를 들어, 클래스 A가 클래스 B의 메서드나 데이터를 필요로 하면, 클래스 A는 클래스 B에 **의존**합니다.
2. **의존성 주입 (Dependency Injection)**
    - 클래스가 직접 다른 객체를 생성하거나 관리하지 않고, 필요한 의존성을 외부에서 전달받습니다.
    - 객체의 생성과 사용의 책임을 분리합니다.

---
### **DI의 주요 목적**
1. **객체 간의 결합도를 낮춤**
    - 한 클래스가 다른 클래스에 강하게 의존하지 않도록 하여 코드 변경에 유연하게 대처할 수 있습니다.
2. **테스트 용이성 향상**
    - 테스트 시 의존성을 쉽게 모의 객체(mock)로 대체할 수 있어 단위 테스트가 쉬워집니다.
3. **유지보수성 향상**
    - 의존성 관리를 중앙에서 처리하므로 코드 유지보수가 쉬워집니다.

---
### **DI의 주입 방식**
DI는 의존성을 객체에 전달하는 방법에 따라 **세 가지**로 구분됩니다:
1. **생성자 주입 (Constructor Injection)**
    - 의존성을 클래스 생성자에서 전달받습니다.
    - 가장 일반적으로 권장되는 방법.
```java
@RestController
public class PostController {
    private final PostService postService;

    // 생성자 주입
    public PostController(PostService postService) {
        this.postService = postService;
    }
}
```
2. **세터 주입 (Setter Injection)**
- 의존성을 세터 메서드를 통해 전달받습니다.
- 선택적인 의존성 주입이 필요할 때 사용됩니다.
```java
@RestController
public class PostController {
    private PostService postService;

    // 세터 주입
    public void setPostService(PostService postService) {
        this.postService = postService;
    }
}
```
3. **필드 주입 (Field Injection)**
- 의존성을 클래스 필드에 직접 주입합니다.
- 간단히 사용할 수 있으나 테스트가 어려워 권장되지 않는 방식입니다.
```java
@RestController
public class PostController {
    @Autowired
    private PostService postService;
}
```
---
### **DI를 활용하는 주요 프레임워크**

DI는 Spring Framework와 같은 **의존성 관리 프레임워크**에서 사용됩니다. Spring은 DI 컨테이너(또는 IoC 컨테이너)를 통해 의존성을 관리하고 주입합니다.

---
### **DI의 예**
1. **클래스 간 의존성 없이 직접 생성한 경우**

### **DI를 활용하는 주요 프레임워크**

DI는 Spring Framework와 같은 **의존성 관리 프레임워크**에서 사용됩니다. Spring은 DI 컨테이너(또는 IoC 컨테이너)를 통해 의존성을 관리하고 주입합니다.

---

### **DI의 예**

1. **클래스 간 의존성 없이 직접 생성한 경우**
```java
public class PostController {
    private PostService postService = new PostService();
}

```
- 여기서 `PostController`는 `PostService`의 생성과 관리까지 책임집니다.
- 결합도가 높아지고 테스트가 어려워집니다.
2. **DI를 활용한 경우**
```java
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
}
```
1. - `PostController`는 `PostService`의 생성과 관리 책임을 가지지 않습니다.
    - 외부에서 주입받으므로 결합도가 낮아집니다.

---
### **DI와 Spring**
Spring Framework는 DI를 자동으로 처리해주는 IoC(Inversion of Control) 컨테이너를 제공합니다.
- Spring에서 DI는 `@Autowired`, `@Component`, `@Service`, `@Repository`, `@Controller` 등의 어노테이션을 통해 구현됩니다.
- **IoC 컨테이너**가 객체를 생성하고 의존성을 관리하여 주입합니다.

---
### **DI와 유사 개념: IoC**
DI는 IoC(Inversion of Control, 제어의 역전)의 한 구현 방법입니다.
- **IoC**는 객체의 생성과 생명주기 관리를 개발자가 아닌 프레임워크가 책임지는 개념입니다.
- **DI**는 IoC를 구현하는 방식 중 하나로, 의존성을 외부에서 주입받는 것입니다.

---
### **요약**
- DI(Dependency Injection)는 객체 간 의존성을 외부에서 주입받는 설계 패턴입니다.
- 이를 통해 **결합도를 낮추고**, **테스트 용이성**과 **유지보수성**을 높입니다.
- Spring과 같은 프레임워크에서 IoC 컨테이너를 활용해 DI를 자동으로 처리합니다.