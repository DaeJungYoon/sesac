# DTO
- Data Transfer Object
- 계층간 데이터 전달을 위한 객체이다.
- Entity와 DTO를 분리하는 이유
    - 도메인 모델의 변경으로부터 API 스펙을 보호
    - 불필요한 데이터 전송 방지
    - 양방향 연관관계로 인한 순환참조 문제 방지
    - API 스펙에 맞는 유연한 데이터 구조 제공
## Entity vs DTO
- Entity
    - 실제 DB 테이블과 매핑되는 클래스이다.
    - 기본 키, 컬럼, 연관 관계(예: `@OneToMany`, `@ManyToOne`) 등을 정의한다.
    - 비즈니스 로직을 포함할 수 있다.
    - 데이터의 영속성을 담당한다.
- DTO
    - 오직 데이터 전달만을 위한 클래스이다.
    - 클라이언트에게 필요한 필드만 포함한다.
    - 비즈니스 로직을 포함하지 않는다.
    - 각 API에 맞는 데이터 구조 제공한다.
- 참고) - `ModelMapper`, `MapStruct` 등의 매핑 라이브러리를 활용할 수 있다.

---
## Request DTO
- 클라이언트에서 서버로 데이터를 전달할 때 사용하는 객체
- 주로 @RequestBody와 함께 사용된다.
- 데이터 유효성 검증을 위한 어노테이션이 포함될 수 있다.
- @RequestBody 와 사용되기 위해 `@NoArgsConstructor`를 필요로 한다.
## Response DTO
- 서버에서 클라이언트로 데이터를 반환할 때 사용하는 객체
- Entity의 민감한 정보를 제외하고 필요한 정보만 전달한다.
- 여러 Entity의 데이터를 조합하여 반환할 수 있다.
- 필드에 `final`을 함께 사용한다.

---
## Builder 패턴
- 복잡한 객체의 생성 과정과 표현 방법을 분리하여 다양한 구성의 인스턴스를 만드는 생성 패턴이다.
- 일반 생성자의 문제점
    - 매개변수가 많을 경우 가독성이 떨어진다.
    - 어떤 값이 어떤 필드에 매핑되는지 알기 어렵다.
    - 선택적 매개변수가 많을 경우 생성자 오버로딩이 많아진다.
- 특징
    - 가독성 향상
        - 생성자의 파라미터가 많을 때 각 값의 의미를 명확히 알 수 있다
        - 선택적 파라미터 처리가 용이하다
    - 불변성 보장
        - 객체 생성 시점에 모든 값을 설정한다
        - setter 사용을 줄여 안전한 객체 생성 가능하다
    - 유연성
        - 필수값과 선택값을 구분하여 처리 가능하다
        - 다양한 객체 생성 패턴을 지원한다
- 정의
    - lombok의 `@Builder`를 활용하여 사용할 수 있다.
    - Entity의 경우 id를 제외한 빌더가 필요하므로 메서드 레벨에 정의한다.
        ```java
        @Entity 
        @Getter
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public class User {
            @Id @GeneratedValue
            private Long id;
            
            private String name;
            private String email;
        
            @Builder
            public User(String name, String email) {
                this.name = name;
                this.email = email;
            }
        }
        ```

    - DTO의 경우 전체 필드에 대해 빌더가 필요하므로 클래스 레벨에 정의해도 괜찮다.
        - 생성자가 없으면 자동으로 모든 필드에 대한 생성자를 만들어준다.
        - 따로 생성자를 만들었으면 `@AllArgsConstructor`와 같이 사용한다.
        
        ```java
        @Getter
        @Builder //생성자
        @NoArgsConstructor // Request 받을 때 (기본 생성자)
        @AllArgsConstructor // 빌더를 사용할 때, 전체를 위한 공간을 만들때(모든 필드에 대한 생성자)
        public class UserCreateRequestDto {
        
            private String name;
            private String email;
            
        }
        ```
        
- 사용법
    ```java
    User user = User.builder()
    	.name("이름")
    	.email("이메일")
    	.build();
    ```

---

## 정적 팩토리 메서드 패턴
- 객체 생성을 캡슐화하는 패턴
- 생성자 대신 static 메서드를 통해 객체를 생성
- 특징
    - 명확한 의도 표현
        - `from()`이나 `of()` 같은 메서드 이름을 통해 객체 생성 의도를 명확히 표현할 수 있다.
    - 캡슐화된 객체 생성
        - 정적 팩토리 메서드는 생성자를 직접 노출하지 않아 객체 생성 로직을 캡슐화할 수 있다.
        - DTO를 생성하는 과정에서 추가적인 검증이나 데이터 변환 로직이 필요한 
          경우 생성자 대신 팩토리 메서드에 로직을 넣을 수 있다.
        - 호출할 때마다 새로운 객체를 생성할 필요가 없다. (캐싱, 객체 풀링 등 가능)
    - 객체 생성의 유연성
        - 하위 자료형 객체를 반환할 수 있다.
            - 예) `결제` 객체에 대한 생성을 하였을 때 `OO결제` 인스턴스 반환
    - 무결성 보장
        - 생성자를 private으로 하면 불완전하거나 잘못된 상태로 객체가 생성되는 것을 방지할 수 있다.
        - 객체 생성 시점에 추가적인 검증 로직을 수행할 수 있다.
- 정의
    ```java
    @Getter
    @Builder
    public class UserResponseDto {
       private final Long id;
       private final String name;
       private final String email;
       //static 인스턴스를 생성하기 위해 클래스를 가질 수 밖에 없다.
       public static UserResponseDto from(User user) { 
           return UserResponseDto.builder()
                   .id(user.getId())
                   .name(user.getName())
                   .email(user.getEmail())
                   .build();
       }
    }
    ```
    
- 사용
```java
    UserResponseDto userResponseDto = UserResponseDto.from(user);
```
