## 영속성
- 영속성(Persistence)은 데이터를 생성한 프로그램이 종료되어도 사라지지 않는 데이터의 특성이다.
- 영속성 데이터
    - 하드디스크에 파일로 저장된 데이터
    - 데이터베이스에 저장된 데이터
    - 프로그램이 종료되어도 유지됨
- 비영속성 데이터
    - 프로그램의 메모리(RAM)에만 존재하는 데이터
    - Java의 경우 객체가 메모리에만 있는 상태
    - 프로그램이 종료되면 모두 사라짐
## JDBC
- Java Database Connectivity
- 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API이다.
- 모든 자바의 데이터베이스 연동 기술의 근간이다.

### 특징
- 장점
    - 표준 인터페이스를 제공한다.
    - 데이터베이스 벤더에 관계없이 동일한 코드 사용이 가능하다.
    - 낮은 수준의 데이터베이스 작업에 대한 직접적인 제어가 가능하다
- 단점
    - 반복적인 코드가 많다. (Connection, PreparedStatement, ResultSet 등)
    - SQL문을 직접 문자열로 작성해야 한다.
    - 예외 처리가 복잡하다.

---

## MyBatis
- SQL Mapper 프레임워크
- XML 또는 어노테이션으로 SQL을 별도로 관리할 수 있다.

### 특징
- 장점
    - SQL을 별도의 파일로 분리하여 관리할 수 있다.
    - 동적 SQL을 작성하기 쉽다.
    - 복잡한 JDBC 코드가 없다.
    - 결과를 자바 객체로 자동 매핑해준다.
- 단점
    - SQL을 직접 작성해야 한다.
    - 데이터베이스 벤더에 종속적인 SQL을 작성해야 할 수 있다.
    - JPA에 비해 객체지향적이지 않다.

---

## ORM
- Object-Relational Mapping
- 객체와 관계형 데이터베이스를 매핑하는 기술이다.
- 객체지향 프로그래밍과 관계형 데이터베이스 간의 패러다임 불일치를 해결한다.
- 대표적으로 JPA, Hibernate가 있다.

---
## JPA
- Java Persistence API
- 자바 진영의 ORM 표준 명세이다.
- 실제 구현체가 아닌 인터페이스의 모음이다.
- 대표적인 구현체로 Hibernate가 있다.

### 특징
- 장점
    - 객체지향적인 코드 작성이 가능하다.
    - 데이터베이스에 독립적인 개발이 가능하다.
    - SQL을 직접 작성하지 않아도 된다.
    - 1차 캐시, 지연 로딩 등의 성능 최적화 기능을 제공한다.
- 단점
    - 복잡한 쿼리는 직접 작성해야 할 수 있다.

---

## Hibernate
- JPA의 대표적이고 널리 사용되는 구현체이다

### 특징
- JPA 표준 기능 외 추가 기능 제공
    - 더 다양한 매핑 어노테이션
    - 고급 캐싱 전략
    - 네이티브 SQL 지원

---
## Spring Data JPA
- JPA를 더 편리하게 사용할 수 있도록 스프링에서 제공하는 프로젝트
- Repository 인터페이스를 통한 추상화된 데이터 접근 계층을 제공한다
- JPA Provider(Hibernate 등)를 한번 더 추상화한 것이다

### 특징
- 장점
    - 인터페이스만으로 구현체를 만들어준다
    - 메소드 이름만으로 쿼리 생성이 가능하다
    - 페이징, 정렬 등 데이터 접근 코드를 자동으로 제공한다.
    - 반복적인 CRUD 작업을 위한 공통 인터페이스 제공한다.
    - 명시적인 설정 없이도 JPA를 스프링과 통합해서 사용 가능하다.
- 단점
    - JPA와 마찬가지로 복잡한 쿼리 처리가 어려울 수 있다
    - 메소드 이름이 길어질 수 있다 (findByLastnameAndFirstname 등)
    - JPA/Hibernate를 이해하지 못하면 문제 해결이 어려울 수 있다

#### 하고 싶은 것
- DB 랑 연결하고 싶음 
	- JDBC 이용
		- MyBatis
		- ORM(JPA)
![[Pasted image 20241230135111.png]]


bulid.gradle에 dependencies에 추가를 해야 db를 사용할 수 있음


``` 
# database와 연결 spring.datasource.url=jdbc:mysql://localhost:3306/demodb spring.datasource.username=root spring.datasource.password=password spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver 

# 추가 설정

spring.jpa.show-sql=true               # JPA가 생성하는 SQL을 콘솔에 출력
spring.jpa.hibernate.ddl-auto=create   # 데이터베이스 스키마 자동 생성
spring.jpa.hibernate.ddl-auto=update   # 서버 새로고침 할때마다 데이터 리셋 되는 것을 방지 하기 위해