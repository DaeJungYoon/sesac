## 자바에서 Checked Exception과 Unchecked Exception에 대해서 설명해주세요.

백엔드와 관련된 질문이에요.

Checked Exception은 **컴파일 시점에 확인**되며, **반드시 처리해야 하는 예외**입니다. 자바에서는 `IOException`, `SQLException` 등이 이에 속합니다. Checked Exception을 유발하는 메서드를 호출하는 경우, 메서드 시그니처에 `throws`를 사용하여 호출자에게 예외를 위임하거나 메서드 내에서 try-catch를 사용하여 해당 예외를 반드시 처리해야합니다.

Unchecked Exception은 **런타임 시점에 발생**하는 예외로, 컴파일러가 처리 여부를 강제하지 않습니다. 자바에서는 `RuntimeException`을 상속한 예외들이 해당됩니다. 일반적으로 프로그래머의 실수나 코드 오류로 인해 발생합니다.

## 각각 언제 사용해야 할까요? 🤔

> 정답이 없는 영역이라고 생각해요. 자신의 주관을 만들면서 학습해봐도 좋을 것 같아요!

Checked Exception은 외부 환경과의 상호작용에서 발생할 가능성이 높은 예외에 적합합니다. 예를 들어, 파일 입출력, 네트워크 통신 등에서 발생할 수 있는 예외는 Checked Exception으로 처리하는 것이 좋습니다. 이러한 예외는 예측 가능하며, 호출하는 쪽에서 적절히 처리할 수 있는 여지가 있습니다.

Uncheked Exception은 코드 오류, 논리적 결함 등 프로그래머의 실수로 인해 발생할 수 있는 예외에 적합합니다. 예를 들어, null 참조 또는 잘못된 인덱스 접근 등은 호출자가 미리 예측하거나 처리할 수 없기 때문에 Unchecked Exception으로 두는 것이 좋습니다.

## Error와 Exception의 차이는 무엇인가요? 🤓

Error는 주로 JVM에서 발생하는 심각한 문제로, `OutOfMemoryError`, `StackOverflowError` 등 시스템 레벨에서 발생하는 오류입니다. 이는 일반적으로 프로그램에서 처리하지 않으며, **회복이 어려운 오류**에 속하며, 애플리케이션 코드에서 복구할 수 없는 심각한 문제를 나타냅니다.

반면, Exception은 프로그램 실행 중 발생할 수 있는 오류 상황을 나타냅니다. 대부분의 경우 **회복 가능성**이 있으며, 프로그램 내에서 예외 처리를 통해 오류 상황을 제어할 수 있습니다. Exception은 다시 `Checked Exception`과 `Unchecked Exception`으로 나눌 수 있습니다.

## 추가 학습 자료를 공유합니다.

- [[10분 테코톡] 케로의 예외처리](https://youtu.be/mrrEPbGF6hQ?si=CKhaV9Gwu4Qx97Y1)
- [기억보단 기록을 - 좋은 예외(Exception) 처리](https://jojoldu.tistory.com/734)
- [custom exception을 언제 써야 할까?](https://tecoble.techcourse.co.kr/post/2020-08-17-custom-exception/)