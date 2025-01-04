**Lombok**은 **자바 개발**에서 **보일러플레이트 코드(반복되는 코드)**를 줄여주는 **라이브러리**입니다. 주로 **POJO**(Plain Old Java Object) 클래스에서 반복적으로 작성해야 하는 코드들을 자동으로 생성해줍니다. Lombok은 **컴파일 타임**에 코드를 생성하기 때문에, 실제 실행되는 코드에 포함되지는 않지만, 컴파일러가 처리하면서 코드가 자동으로 생성됩니다.

### Lombok의 주요 기능

Lombok은 다양한 어노테이션을 제공하여 개발자가 반복적으로 작성해야 하는 코드들을 자동으로 생성해줍니다. 대표적인 기능들은 다음과 같습니다:

1. **Getter/Setter 메소드 자동 생성**:
    - Lombok은 `@Getter`와 `@Setter` 어노테이션을 사용하여 필드에 대한 getter/setter 메소드를 자동으로 생성합니다.
```java
@Getter
@Setter
public class Person {
    private String name;
    private int age;
}

```
- 위 코드에서 Lombok은 `getName()`, `setName(String name)`, `getAge()`, `setAge(int age)` 메소드를 자동으로 생성합니다.
    
2. **생성자 자동 생성**:
    - `@NoArgsConstructor`: 기본 생성자 (매개변수가 없는 생성자)를 자동으로 생성합니다.
    - `@AllArgsConstructor`: 모든 필드를 매개변수로 받는 생성자를 자동으로 생성합니다.
    - `@RequiredArgsConstructor`: `final` 필드나 `@NonNull` 어노테이션이 붙은 필드를 매개변수로 받는 생성자를 자동으로 생성합니다.
```java
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
}
```
- 위 코드에서 Lombok은 `Person(String name, int age)`와 같은 생성자를 자동으로 생성합니다.
    
3. **`toString`, `equals`, `hashCode` 메소드 자동 생성**:
    - `@ToString`: `toString()` 메소드를 자동으로 생성합니다.
    - `@EqualsAndHashCode`: `equals()`와 `hashCode()` 메소드를 자동으로 생성합니다.
```java
@ToString
@EqualsAndHashCode
public class Person {
    private String name;
    private int age;
}
```
- 위 코드에서 Lombok은 `toString()`, `equals()`, `hashCode()` 메소드를 자동으로 생성합니다.
    
4. **`@Builder` 패턴 지원**: 
    - Lombok은 빌더 패턴을 쉽게 사용할 수 있도록 `@Builder` 어노테이션을 제공합니다. 이를 통해 객체를 생성할 때 더 읽기 쉬운 방식으로 필드를 설정할 수 있습니다.
```java
@Builder
public class Person {
    private String name;
    private int age;
}

Person person = Person.builder()
    .name("John")
    .age(30)
    .build();
```
- 위와 같은 방식으로 객체를 빌더 패턴을 통해 쉽게 생성할 수 있습니다.
    
5. **`@NonNull`**
    - `@NonNull` 어노테이션은 필드나 매개변수가 `null`인 경우, `NullPointerException`을 던지도록 하는 기능을 제공합니다. 주로 `@RequiredArgsConstructor`와 함께 사용됩니다.
```java
public class Person {
    @NonNull private String name;
    @NonNull private Integer age;
}
```
- 위 코드에서 `name`과 `age`는 `null`이 될 수 없으며, `null`을 전달하려고 하면 예외가 발생합니다.
    
6. **`@Cleanup`**:
    
    - 자원을 자동으로 닫아주는 어노테이션입니다. 예를 들어 `InputStream`이나 `OutputStream` 같은 자원을 사용할 때, 자동으로 자원을 닫아줍니다.
```java
@Cleanup
InputStream inputStream = new FileInputStream("file.txt");
```
### Lombok을 사용하는 이유

Lombok을 사용하면, 자주 작성해야 하는 **보일러플레이트 코드**들을 자동으로 생성해주기 때문에, 개발자가 코드 작성에 드는 시간을 줄여주고, 코드가 더 간결하고 읽기 쉬워집니다.

### Lombok을 사용하는 방법

1. **Lombok 의존성 추가**:
	1. - **Gradle**을 사용할 경우:
```groovy
dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.24'
    annotationProcessor 'org.projectlombok:lombok:1.18.24'
}
```

1. **IDE 설정**: Lombok은 **컴파일 타임에** 코드를 생성하므로, Lombok 어노테이션을 사용하려면 IDE가 Lombok을 인식할 수 있도록 설정해야 합니다. **IntelliJ IDEA**와 **Eclipse**와 같은 IDE에서는 Lombok을 인식하기 위한 플러그인 설치가 필요할 수 있습니다.
    
### 결론

Lombok은 자바 개발에서 자주 작성하는 **보일러플레이트 코드**를 줄여주는 유용한 라이브러리입니다. 이를 사용하면 코드가 간결하고 읽기 쉬워지며, 개발자의 생산성을 높이는 데 도움을 줍니다.