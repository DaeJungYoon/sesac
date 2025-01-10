## [리액트의 Controlled Component와 Uncontrolled Component의 차이점에 대해서 설명해주세요.](https://www.maeil-mail.kr/question/17)

프론트엔드와 관련된 질문이에요.

**Controlled Component**는 리액트 상태(state)를 통해 입력값을 제어하는 컴포넌트를 말합니다. 이 방식에서는 입력 요소의 값(value)을 리액트 상태와 동기화하고, 사용자가 입력을 변경할 때마다 onChange 이벤트 핸들러를 통해 상태를 업데이트합니다. useState를 활용한 input value를 제어하는 상황을 예시로 들 수 있습니다. value는 리액트 상태로 관리되며, onChange 이벤트가 발생할 때마다 상태가 업데이트됩니다. Controlled Component의 주요 장점은 입력값이 리액트의 상태로 관리되므로, 입력값을 쉽게 검증하고, 변경할 수 있으며, 복잡한 폼 로직을 처리하는 데 유리하다는 것입니다.

**Uncontrolled Component**는 리액트의 상태가 아닌, DOM 자체가 입력값을 제어하는 방식입니다. 즉, 입력 요소의 값은 DOM에서 직접 관리되며, 리액트는 이를 제어하지 않습니다. 이 방식에서는 `ref`를 사용하여 DOM 요소에 직접 접근해 값을 읽어오거나 조작할 수 있습니다.

input과 관련 된 ref는 useRef를 사용해 생성된 참조 객체로, 입력값을 직접 접근하고 조작할 수 있습니다. Uncontrolled Component는 상대적으로 간단한 폼이나 초기값이 중요한 상황에서 사용할 수 있습니다.

## Controlled Component와 Uncontrolled Component를 통해 상태를 관리하는 것 중 어느 상황에 어떤 방법을 선택해야 하나요?

ref를 사용하면 DOM을 통해 직접 접근하여 값을 읽어오기때문에, 단순한 입력 필드가 포함된 폼에서 ref를 사용하는 것이 더 간단하고 성능이 좋을 수 있습니다. 사용자가 제출 버튼을 클릭했을 때만 입력값을 가져오면 되는 경우를 예로 들 수 있습니다.

만약에 값을 입력할때마다 유효성 검증을 실시간을 해주어야하는 경우에는 Controlled Component를 사용하는 것이 좋습니다.

## 추가 학습 자료를 공유합니다.

- [[10분 테코톡] 세인의 제어 컴포넌트와 비제어 컴포넌트](https://www.youtube.com/watch?v=PBgQKK6nelo&t=253s)