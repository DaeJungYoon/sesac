# JPA
- **Java 애플리케이션에서 객체를 관계형 데이터베이스에 매핑하기 위한 표준 사양**입니다. 
- 즉, 객체 지향 프로그래밍과 관계형 데이터베이스 간의 데이터를 다루는 데 필요한 기능을 제공합니다.

## 주요 특징
1. **ORM(Object-Relational Mapping)**
    - 객체(클래스)와 데이터베이스의 테이블을 매핑합니다.
    - SQL을 직접 작성하지 않고, 객체 중심으로 데이터를 처리합니다.
2. **표준 사양**
    - JPA는 Java EE(현재 Jakarta EE)에서 제공하는 표준입니다.
    - Hibernate, EclipseLink, DataNucleus 등 다양한 구현체가 존재합니다.
3. **생산성 향상**
    - 데이터를 CRUD(생성, 조회, 수정, 삭제)할 때, SQL을 직접 작성하지 않아도 됩니다.
    - 애플리케이션 개발 속도를 높여줍니다.

### JPA의 핵심 개념

1. **엔티티(Entity)**
    - 데이터베이스 테이블에 매핑되는 클래스입니다.
    - 예시
``` java
@Entity // JPA 엔티티임을 선언
public class User {
    @Id // 기본 키(primary key)로 설정
    @GeneratedValue // 자동 생성 (auto-increment)
    private Long id;

    private String name;
    private String email;
    
    // Getter, Setter, toString 생략
}
```
2. **영속성 컨텍스트(Persistence Context)**
- JPA에서 엔티티를 관리하는 환경입니다.
- 엔티티를 캐싱하여 데이터베이스와의 작업을 효율적으로 처리합니다.
- 변경 감지를 통해 데이터가 수정되면 자동으로 반영됩니다.
3. **JPQL(Java Persistence Query Language)**
- 데이터베이스에 의존적이지 않은 쿼리 언어입니다.
- SQL과 유사하지만, 테이블이 아니라 엔티티 객체를 대상으로 쿼리합니다.
- 예시:
 ```java
 @PersistenceContext
private EntityManager em;

public List<User> findAllUsers() {
    return em.createQuery("SELECT u FROM User u", User.class)
             .getResultList();
}
```
4. **CRUD 작업**
- 데이터를 저장, 조회, 수정, 삭제할 때 간단한 메서드를 사용합니다.
---
### 장점
1. **생산성 증가**
    - SQL을 직접 작성하지 않고도 데이터를 조작할 수 있어 개발 속도가 빨라집니다.
2. **데이터베이스 독립성**
    - 특정 데이터베이스에 종속되지 않고, 다른 데이터베이스로 쉽게 변경할 수 있습니다.
3. **캐싱**
    - 영속성 컨텍스트를 통해 1차 캐시를 제공하여 성능이 향상됩니다.
---
### Hibernate와의 관계
- Hibernate는 JPA의 대표적인 구현체 중 하나입니다.
- JPA는 인터페이스(표준 사양)이고, Hibernate는 이를 구현한 라이브러리입니다.
---
### 정리
JPA는 Java 개발자가 데이터베이스 작업을 더욱 효율적으로 수행하도록 도와주는 강력한 도구입니다. ORM을 활용하여 코드의 가독성과 유지보수성을 높이고, 데이터베이스에 의존적이지 않은 코드를 작성할 수 있습니다.

