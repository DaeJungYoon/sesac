## [TCP 3-way handshake에 대해서 설명해주세요.](https://www.maeil-mail.kr/question/76)

백엔드와 관련된 질문이에요.

TCP 3-way handshake는 TCP/IP 네트워크에서 안정적이고 연결 지향적인 통신을 설정하기 위해 사용되는 절차입니다. 이 절차는 클라이언트와 서버 간에 신뢰할 수 있는 연결을 설정하기 위해 세 개의 메시지(세그먼트)를 교환하는 과정을 포함합니다.

우선 클라이언트는 서버에 연결을 요청하는 SYN 세그먼트를 보내는데요. 이 세그먼트에는 초기 순서 번호(Sequence Number)와 윈도우 크기(Window Size) 정보가 포함되어 있습니다.

이후 서버는 클라이언트의 요청을 수락하고, SYN과 ACK 플래그가 설정된 세그먼트를 클라이언트에 보냅니다. 이 세그먼트는 서버의 초기 순서 번호와 클라이언트의 초기 순서 번호에 대한 응답(ACK=클라이언트의 초기 순서 번호 + 1)을 포함합니다.

클라이언트는 서버의 응답을 확인하고, ACK 플래그가 설정된 세그먼트를 서버에 보냅니다. 이 세그먼트는 서버의 순서 번호에 대한 응답(ACK=서버의 초기 순서 번호 + 1)을 포함합니다. 이 절차가 완료되면 클라이언트와 서버 간에 신뢰할 수 있는 연결이 설정되고, 데이터 전송이 시작될 수 있습니다.

## 추가 학습 자료를 공유합니다.

- [[10분 테코톡] 🔮 수리의 TCP/IP](https://youtu.be/BEK354TRgZ8?feature=shared)
- [[ 네트워크 쉽게 이해하기 22편 ] TCP 3 Way-Handshake & 4 Way-Handshake](https://mindnet.tistory.com/entry/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EC%89%BD%EA%B2%8C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-22%ED%8E%B8-TCP-3-WayHandshake-4-WayHandshake)