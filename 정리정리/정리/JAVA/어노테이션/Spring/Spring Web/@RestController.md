
# @RestController
- Java Spring Framework에서 사용되는 어노테이션(annotation)
- RESTful 웹 서비스를 구현할 때 사용
- 어노테이션은 클래스가 **컨트롤러 역할** 하고
- **RESTful 방식으로 JSON 또는 XML 데이터를 반환하는 HTTP 요청 핸들러**임을 Spring에게 알리기 위해 사용
## 주요 특징
1. **컨트롤러 역할**
    - Spring MVC의 컨트롤러 컴포넌트를 정의합니다.
    - HTTP 요청을 처리하고 응답을 반환하는 메서드를 포함합니다.
2. **자동으로 JSON/XML 반환**
    - `@RestController`는 `@Controller`와 `@ResponseBody`를 결합한 역할을 합니다.
    - 반환값이 HTML 뷰가 아니라, JSON 또는 XML 형식의 데이터를 직렬화하여 클라이언트로 전달합니다.
### 사용 예시
```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스는 REST API를 제공하는 컨트롤러임을 선언
@RequestMapping("/api") // 공통 URL 경로 설정
public class MyController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```
### 코드 설명
- `@RestController`:
    - 클래스가 RESTful 컨트롤러임을 나타냅니다.
- `@RequestMapping("/api")`:
    - 해당 클래스 내 모든 엔드포인트 URL에 `/api`를 기본 경로로 추가합니다.
- `@GetMapping("/hello")`:
    - `GET /api/hello` 요청을 처리합니다.
- `return "Hello, World!";`:
    - 요청에 대해 `"Hello, World!"`라는 문자열을 JSON 형식으로 응답합니다.

### 요청과 응답
요청: `GET http://localhost:8080/api/hello`  
응답:
```json
"Hello, World!"
```
### 주요 장점
- RESTful API를 쉽게 구현 가능.
- JSON 형식의 데이터 반환이 기본 설정.
- Spring Boot와 결합하면 빠르게 API를 개발할 수 있음.