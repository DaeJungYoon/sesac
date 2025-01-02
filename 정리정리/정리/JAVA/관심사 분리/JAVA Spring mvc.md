# JAVA Spring mvc

## Spring MVC
- Spring Framework에서 제공하는 웹 모듈이다.
- MVC(Model-View-Controller) 디자인 패턴을 기반으로 웹 애플리케이션을 구축한다.
- 구성 요소를 분리하여 개발하므로 무거운 프로젝트도 효율적으로 관리할 수 있다.

---

### MVC 패턴의 구성요소
- Model(처리)
    - 애플리케이션의 데이터와 비즈니스 로직을 담당한다.
    - Service와 Repository가 Model에 해당한다.
- View(응답)
    - 사용자에게 보여지는 화면을 담당한다.
    - HTML, JSP, Thymeleaf 등이 View에 해당한다.
    - REST API를 사용할 경우 JSON 형태의 데이터가 View가 된다.
- Controller(요청)
    - 사용자의 요청을 받아서 Model과 View를 연결하는 역할을 한다.
    - @Controller 또는 @RestController 어노테이션을 사용한다.
    
## @Autowired 어노테이션
- 스프링 컨테이너가 자동으로 의존성을 주입할 때 사용하는 어노테이션이다.   
- 특징
    - 타입을 기준으로 의존성을 주입한다.
    
    ```java
    @Autowired
    private UserRepository userRepository;
    ```
    
- @Autowired 사용 가능 위치
    
    - 생성자 (생성자가 하나면 @Autowired 생략 가능)
    - 수정자(setter)
    - 필드
- @Autowired 동작 원리
    
    - 주입 시점
        1. 스프링 컨테이너가 빈을 생성한다.
        2. @Autowired가 붙은 위치에 의존성을 주입한다.
    - 주입 대상 탐색
        1. 타입이 같은 빈을 찾는다.
        2. 여러 개의 빈이 있다면:
            - @Primary가 있는 빈을 주입
            - @Qualifier로 지정된 빈을 주입
            - 이름이 같은 빈을 주입
        3. 위 조건으로도 구분이 안 되면 오류 발생