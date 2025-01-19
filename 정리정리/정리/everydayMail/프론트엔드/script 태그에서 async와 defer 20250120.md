## [script 태그에서 async와 defer의 차이점에 대해서 설명해주세요.](https://www.maeil-mail.kr/question/37)

프론트엔드와 관련된 질문이에요.

먼저, 두 속성 모두 스크립트를 비동기적으로 로드한다는 공통점이 있습니다. 하지만 실행 시점에서 중요한 차이가 있습니다.

### [](https://www.maeil-mail.kr/question/37#async-%EC%86%8D%EC%84%B1)async 속성

`async` 속성에는 다음과 같은 특징들이 존재합니다.

1. 스크립트를 비동기적으로 다운로드합니다.
2. 다운로드가 완료되면 즉시 실행됩니다.
3. HTML 파싱과 병렬로 진행되지만, 스크립트 실행 시 HTML 파싱이 잠시 중단됩니다.
4. 여러 async 스크립트가 있을 경우, 다운로드가 완료되는 순서대로 실행됩니다.

### defer 속성

`defer` 속성에는 다음과 같은 특징들이 존재합니다.

1. 스크립트를 비동기적으로 다운로드합니다.
2. HTML 문서 파싱이 완전히 끝난 후에 실행됩니다.
3. DOMContentLoaded 이벤트 발생 직전에 실행됩니다.
4. 여러 defer 스크립트가 있을 경우, HTML에 작성된 순서대로 실행됩니다.

따라서, 실행 순서가 중요한 스크립트나 메인 어플리케이션의 로직을 담고 있는 스크립트의 경우 `defer`를 사용하고, 독립적으로 실행되는 스크립트의 경우 (예들 들면 Google Analytics 같은 분석 도구) `async`를 사용하는 것이 적절합니다.

이러한 차이를 이해하고 적절히 활용하면 웹 페이지의 로딩 성능을 최적화하는 데 큰 도움이 됩니다.

## 📚 추가 학습 자료를 공유합니다.

- [[zorefcode] #shorts Async vs Defer](https://www.youtube.com/shorts/3peCiMg332o)
- [[JAVASCRIPT.INFO] defer, async 스크립트](https://ko.javascript.info/script-async-defer)