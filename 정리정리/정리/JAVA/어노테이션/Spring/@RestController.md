
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
