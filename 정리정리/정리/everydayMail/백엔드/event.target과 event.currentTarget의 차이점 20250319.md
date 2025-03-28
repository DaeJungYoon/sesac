## [event.target과 event.currentTarget의 차이점은 무엇인가요?](https://www.maeil-mail.kr/question/117)

프론트엔드와 관련된 질문이에요.

`event.target`과 `event.currentTarget`은 모두 이벤트 객체의 속성이며, 각각 **"이벤트가 실제로 발생한 요소"** 와 **"이벤트 리스너가 연결된 요소"** 를 가리킵니다. 이 둘의 차이점을 이해하려면 이벤트 버블링을 알아야 합니다. 이벤트는 특정 요소에서 발생한 후 부모 요소들로 전파되는 과정(버블링)을 거치는데, 이 과정에서 `target`과 `currentTarget`이 다르게 동작합니다.

예를 들어, 부모 요소에 이벤트 리스너를 등록했지만 자식 요소에서 이벤트가 발생하여 버블링된 상황에서, `target`은 "이벤트가 발생한 요소"인 자식 요소를 가리킵니다. 반면, `currentTarget`은 "이벤트 리스너가 연결된 요소"인 부모 요소를 가리킵니다.

쉽게 말해, `target`은 “사용자가 직접 상호작용한, 즉 이벤트가 발생한 요소”를, `currentTarget`은 “그 이벤트를 듣고 있는 요소”를 나타냅니다. 예를 들어, `<div>` 안에 `<button>`이 있고, `<div>`에 이벤트 리스너가 부착되어 있다면, 버튼을 클릭했을 때 `target`은 `<button>`을, `currentTarget`은 `<div>`를 반환합니다.

이 차이는 이벤트 위임이나 이벤트 전파 처리 시 중요합니다. `target`과 `currentTarget`을 적절히 활용하면, 이벤트 처리 시 원하는 대상을 명확히 지정하여 예기치 않은 동작을 방지할 수 있습니다.

## 📚 추가 학습 자료를 공유합니다.

- [[MDN] Event: currentTarget property](https://developer.mozilla.org/en-US/docs/Web/API/Event/currentTarget)
- [[Mong dev blog] event.target, event.currentTarget의 차이(feat. 이벤트 버블링)](https://mong-blog.tistory.com/entry/JS-eventtarget-eventcurrentTarget%EC%9D%98-%EC%B0%A8%EC%9D%B4feat-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EB%B2%84%EB%B8%94%EB%A7%81)