## [HTML Doctype이 무엇인지 설명해주세요.](https://www.maeil-mail.kr/question/119)

프론트엔드와 관련된 질문이에요.

HTML의 `<!DOCTYPE>`은 웹 브라우저에 해당 문서가 어떤 HTML 버전을 기반으로 작성되었는지 알려주는 역할을 하는 선언문입니다. 문서의 최상단에 위치하며, 브라우저가 HTML 문서를 해석하고 렌더링하는 방식을 결정합니다. 대소문자를 구분하지 않지만, 강조하기 위해 대문자를 사용하는 경우가 많습니다.

과거에는 HTML의 다양한 버전(ex. XHTML 1.1, HTML 4.01 등)이 존재했기 때문에 브라우저가 문서를 올바른 방식으로 해석하기 위해, 적절한 방식으로 Doctype을 직접 지정해야 했습니다. HTML5에 접어들어서는 선언 방식이 단순화되어 `<!DOCTYPE html>`으로 간단하게 선언할 수 있습니다. 이 선언문은 HTML5를 사용하고 있음을 명시합니다.

## Doctype을 선언하지 않아도 되나요? 🤔

아니요, Doctype을 꼭 선언해 주어야 합니다. 만약 Doctype 선언이 없다면 브라우저는 문서를 **쿼크 모드(quirks mode)** 로 렌더링할 수 있습니다. 쿼크 모드는 오래된 웹사이트와의 호환성을 유지하기 위해 표준과 다른 방식으로 동작합니다. 이는 예상치 못한 동작을 발생시킬 수 있습니다. 따라서 정확하고 일관된 렌더링을 위해 Doctype 선언은 필수적입니다. 오늘날에는 대부분 HTML5를 사용하므로 `<!DOCTYPE html>`을 선언해주면 됩니다.

## 📚 추가 학습 자료를 공유합니다.

- [[생활코딩] HTML - DOCTYPE](https://www.youtube.com/watch?v=EgT5520Ztek)
- [[MDN] Doctype](https://developer.mozilla.org/ko/docs/Glossary/Doctype)
- [[위키백과] Document type declaration](https://ko.wikipedia.org/wiki/%EB%AC%B8%EC%84%9C_%ED%98%95%EC%8B%9D_%EC%84%A0%EC%96%B8)