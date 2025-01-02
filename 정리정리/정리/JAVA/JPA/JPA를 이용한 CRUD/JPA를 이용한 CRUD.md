## EntityManager와 EntityTransaction

- EntityManager를 통해 영속성 컨텍스트를 관리
- EntityTransaction을 통해 트랜잭션을 관리
    - 데이터 변경 작업이 끝난 후에는 반드시 `commit()`을 호출해야 한다.
    - 예외가 발생하면 반드시 `rollback()`을 호출해야 한다.
    - 모든 작업이 끝난 후에는 `close()`를 호출해야 한다