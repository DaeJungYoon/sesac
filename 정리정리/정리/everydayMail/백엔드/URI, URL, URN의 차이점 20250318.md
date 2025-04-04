## [URI, URL, URN의 차이점은 무엇인가요?](https://www.maeil-mail.kr/question/149)

백엔드와 관련된 질문이에요.

![](https://github.com/user-attachments/assets/6fabcb82-3a28-4de6-9870-3c466a61b775)

**URI (Uniform Resource Identifier)** 는 인터넷에서 자원을 식별하기 위한 문자열입니다. URI는 URL과 URN을 포함하는 상위 개념입니다. 즉, 특정 자원을 식별하기 위한 포괄적인 방법을 제공하며, 자원의 위치나 이름을 나타낼 수 있습니다.

**URL (Uniform Resource Locator)** 는 URI의 한 형태로, 인터넷상에서 자원의 위치를 나타내는 방식입니다. 자원이 어디에 있는지를 설명하는데 사용되며, 자원에 접근하기 위한 프로토콜을 포함합니다. 예를 들어, 웹페이지의 URL은 해당 페이지가 위치한 서버의 주소와 접근 방법(예: HTTP)을 포함합니다. ex) `https://www.example.com/path/to/resource`

**URN (Uniform Resource Name)** 은 URI의 또 다른 형태로, 자원의 위치와 상관없이 자원의 이름을 식별하는 방식입니다. 자원의 위치가 변하더라도 동일한 식별자를 유지할 수 있게 합니다. 특정 스키마를 따르며, 자원에 대한 영구적인 식별자를 제공합니다. ex) `urn:isbn:0451450523` (특정 책의 ISBN 번호)

## 추가 학습 자료를 공유합니다.

- [URI, URL 그리고 URN](https://hudi.blog/uri-url-urn/)
- [카카오페이 기술 블로그 - URL이 이상해요! Java와 Spring 중 범인은 누구?](https://tech.kakaopay.com/post/url-is-strange/)