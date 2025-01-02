# @NoArgsConstructor
- `@NoArgsConstructor`는 **Lombok**에서 제공하는 어노테이션으로, **파라미터가 없는 기본 생성자**를 자동으로 생성해주는 역할을 합니다.
---
### 주요 기능
1. **기본 생성자 자동 생성**
    - 클래스에 별도로 생성자를 정의하지 않아도, **기본 생성자(no-args constructor)**를 자동으로 추가해줍니다.
2. **코드 간소화**
    - 기본 생성자를 직접 작성하지 않아도 되므로 코드가 간결해집니다.
3. **옵션을 통한 접근 제어**
    - 기본 생성자의 접근 제어를 설정할 수 있습니다. (예: `public`, `protected`, `private`, 등)
---
### 기본 사용법
#### 코드 예시
```java
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Example {
    private String name;
    private int age;
}
```
#### 자동 생성된 코드
Lombok은 다음과 같은 기본 생성자를 자동으로 추가합니다
```java
public Example() {
    // 기본 생성자
}
```
---
### 주요 옵션
#### 1. **`access`**
    
    - 생성자의 접근 수준을 설정합니다.
    - 사용 가능한 값: `AccessLevel.PUBLIC`, `AccessLevel.PROTECTED`, `AccessLevel.PRIVATE`, `AccessLevel.PACKAGE`.
```java
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Example {
    private String name;
}
```
자동 생성된 생성자는 다음과 같습니다.
```java
protected Example() {
    // protected 기본 생성자
}
```
##### 사용 이유
1. **JPA 엔티티에서 기본 생성자 필요**
    - JPA는 엔티티 객체를 리플렉션(reflection) 또는 프록시(proxy) 기술로 생성하기 때문에, **기본 생성자**가 반드시 필요합니다.
    - 이 기본 생성자는 외부에서 직접 호출하지 못하도록 **`protected`**로 제한하여 **객체의 무분별한 생성을 방지**합니다.
2. **불변성과 캡슐화 유지**
    - 필수 값은 생성자를 통해 설정하도록 강제하고, 기본 생성자는 외부에서 사용할 수 없게 제한합니다.
##### 접근 제어의 이유: `AccessLevel.PROTECTED`
 1. **객체 생성 제어**
- 기본 생성자를 `protected`로 설정하면, 같은 패키지나 상속받은 클래스에서만 사용할 수 있습니다.
- 이를 통해 엔티티의 무분별한 생성을 막고, **정확한 상태를 가진 객체만 생성**되도록 강제할 수 있습니다.
2. **JPA 표준 요구사항 준수**
- JPA는 기본 생성자를 필요로 하지만, 이 생성자가 외부에서 호출될 필요는 없습니다.
- 따라서 `protected`로 설정하여 접근 범위를 최소화합니다.
#### 2. **`force`**
- `final` 또는 `@NonNull` 필드가 있는 경우에도 강제로 기본 생성자를 생성합니다.
- 기본 값을 사용하여 초기화됩니다.
```java
@NoArgsConstructor(force = true)
public class Example {
    private final String name;
}
```
자동 생성된 생성자는 다음과 같습니다.
```java
public Example() {
    this.name = null; // 기본 값으로 초기화
}
```

---
### JPA에서의 사용
#### JPA 요구사항
- JPA는 **엔티티 클래스**를 생성할 때 리플렉션(Reflection) 또는 프록시(proxy) 기술을 사용합니다.  
- 따라서, **파라미터가 없는 기본 생성자**가 반드시 필요합니다.  
- 이때 `@NoArgsConstructor`를 활용하면, JPA 요구사항을 쉽게 만족시킬 수 있습니다.

#### 예시
```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 protected로 제한
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
}
```
---
### 장점과 단점
#### 장점
1. **코드 간소화**:
    - 기본 생성자를 직접 작성할 필요 없이 Lombok이 자동으로 생성.
2. **JPA와의 호환성**:
    - JPA 엔티티에서 요구하는 기본 생성자를 쉽게 추가 가능.
3. **유연한 접근 제어**:
    - `access` 옵션을 통해 생성자의 접근 수준을 제어할 수 있음.
#### 단점
1. **코드 가독성**:
    - 어노테이션만 보고 생성자의 구현 내용을 파악하기 어려움.
2. **의존성**:
    - Lombok 라이브러리에 의존.

---
### 정리
`@NoArgsConstructor`는 기본 생성자를 자동으로 추가해주는 Lombok 어노테이션입니다.  
특히 JPA 엔티티에서 기본 생성자가 필수적이므로 자주 사용되며,  
옵션을 통해 접근 제어 수준을 조절하거나 `final` 필드 강제 초기화도 가능합니다.  
이를 활용하면 코드를 간결하고 효율적으로 작성할 수 있습니다.