# JPQL
- JPQL(Java Persistence Query Language)은 Java Persistence API(JPA)에서 사용되는 객체 지향 쿼리 언어입니다. 
- JPQL은 관계형 데이터베이스에 저장된 데이터를 객체 중심으로 조회하거나 조작하기 위해 설계되었습니다. 
- SQL과 유사한 문법을 사용하지만, 데이터베이스 테이블이 아닌 **엔티티(Entity)**와 그 속성에 대해 작업한다는 점에서 차이가 있습니다.

### JPQL의 주요 특징

1. **엔티티 기반**
    - JPQL은 데이터베이스 테이블 대신 JPA에서 정의된 엔티티 클래스를 대상으로 작업합니다.
    - 예를 들어, SQL에서는 테이블 이름을 사용하지만, JPQL에서는 엔티티 이름을 사용합니다.
2. **객체 지향 접근**
    - JPQL은 객체와 연관 관계를 직접 탐색할 수 있습니다.
    - 엔티티 간의 관계(1:1, 1:N, N:M)를 자연스럽게 사용할 수 있습니다.
3. **플랫폼 독립적**
    - JPQL은 특정 데이터베이스에 종속되지 않습니다. JPA 구현체(Hibernate 등)가 JPQL을 SQL로 변환해 데이터베이스에 적합한 쿼리를 실행합니다.

---

### JPQL의 기본 문법

1. **SELECT 쿼리**  
    데이터를 조회하는 데 사용됩니다.
```java
SELECT e FROM Employee e WHERE e.salary > :minSalary
```
    
    - `Employee` 는 엔티티 이름
    - `e.salary` 는 `Employee` 엔티티의 필드
    - `:minSalary` 는 파라미터
2. **UPDATE/DELETE 쿼리**  
    데이터를 수정하거나 삭제할 때 사용됩니다.
```java
UPDATE Employee e SET e.salary = :newSalary WHERE e.department = :dept DELETE FROM Employee e WHERE e.resigned = true
```
    
3. **JOIN**  
    엔티티 관계를 이용한 조인.
```java
SELECT e FROM Employee e JOIN e.department d WHERE d.name = 'HR'
```
    
4. **GROUP BY, HAVING, ORDER BY**  
    SQL과 유사하게 집계 및 정렬 작업도 가능합니다.
```java
SELECT d.name, COUNT(e) FROM Department d JOIN d.employees e  GROUP BY d.name HAVING COUNT(e) > 10 ORDER BY d.name
```

---

### JPQL vs SQL

|**JPQL**|**SQL**|
|---|---|
|엔티티와 속성을 대상으로 작업|테이블과 열을 대상으로 작업|
|객체 지향적 탐색 지원|데이터베이스 관계에 초점|
|JPA가 SQL로 변환 및 실행|데이터베이스에 직접 실행|
|데이터베이스 독립적|데이터베이스 종속적|

### JPQL 사용 예시

```java
String jpql = "SELECT e FROM Employee e WHERE e.department.name = :deptName"; TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class); 
query.setParameter("deptName", "Finance"); List<Employee> employees = query.getResultList();
```

이 코드에서:

- `Employee`는 엔티티 클래스입니다.
- `e.department.name`은 엔티티 관계를 통해 탐색한 속성입니다.
- JPQL 쿼리는 JPA 구현체에 의해 SQL로 변환됩니다.

JPQL은 JPA를 사용한 데이터베이스 작업의 핵심 도구이므로, JPA를 활용할 때 반드시 알아두어야 합니다. 😊