# @RequestParam
Spring Framework에서 **HTTP 요청의 쿼리 파라미터(query parameter)** 또는 **폼 데이터(form data)**를 컨트롤러 메서드의 파라미터로 매핑할 때 사용하는 어노테이션입니다. RESTful API 또는 웹 애플리케이션에서 클라이언트가 URL 쿼리 문자열이나 폼 데이터를 통해 서버에 데이터를 전달할 때 사용됩니다.

---

### 주요 특징

- **쿼리 파라미터 처리**:
    - URL에 포함된 `?key=value` 형식의 데이터를 매핑.
- **폼 데이터 처리**:
    - `application/x-www-form-urlencoded` 형식으로 전송된 데이터를 매핑.

---

### 기본 사용법

#### 예제 1: 단일 파라미터

java

코드 복사

`@RestController @RequestMapping("/users") public class UserController {      @GetMapping("/search")     public String searchUser(@RequestParam("name") String name) {         return "Searching for user: " + name;     } }`

#### 요청 URL

sql

코드 복사

`GET /users/search?name=John`

#### 결과

rust

코드 복사

`Searching for user: John`

#### 설명

1. `@RequestParam("name")`은 요청 URL의 `name` 파라미터 값을 메서드의 `name` 변수로 매핑합니다.
2. 위 요청에서 `name=John`이므로, `name` 변수의 값은 `"John"`이 됩니다.

---

### 옵션: `required`와 `defaultValue`

#### 예제 2: 필수 여부 설정

java

코드 복사

`@GetMapping("/search") public String searchUser(     @RequestParam(value = "name", required = false) String name) {     return name != null ? "Searching for user: " + name : "No name provided"; }`

#### 요청 URL

- `GET /users/search` → 결과: `No name provided`
    
- `GET /users/search?name=Jane` → 결과: `Searching for user: Jane`
    
- `required = false`: 파라미터가 없어도 에러를 발생시키지 않습니다.
    

---

#### 예제 3: 기본값 설정

java

코드 복사

`@GetMapping("/search") public String searchUser(     @RequestParam(value = "name", defaultValue = "Guest") String name) {     return "Searching for user: " + name; }`

#### 요청 URL

- `GET /users/search` → 결과: `Searching for user: Guest`
    
- `GET /users/search?name=Emma` → 결과: `Searching for user: Emma`
    
- `defaultValue = "Guest"`: 요청에 파라미터가 없을 때 기본값을 제공합니다.
    

---

### 여러 파라미터 처리

java

코드 복사

`@GetMapping("/filter") public String filterUsers(     @RequestParam("name") String name,     @RequestParam("age") int age) {     return "Filtering users by name: " + name + " and age: " + age; }`

#### 요청 URL

sql

코드 복사

`GET /users/filter?name=Alice&age=30`

#### 결과

bash

코드 복사

`Filtering users by name: Alice and age: 30`

---

### 리스트 처리

쿼리 파라미터가 배열 또는 리스트 형식일 경우:

java

코드 복사

`@GetMapping("/ids") public String getUsersByIds(@RequestParam List<Integer> ids) {     return "User IDs: " + ids; }`

#### 요청 URL

bash

코드 복사

`GET /users/ids?ids=1&ids=2&ids=3`

#### 결과

less

코드 복사

`User IDs: [1, 2, 3]`

---

### 차이점: `@RequestParam` vs `@PathVariable`

| **특징**          | `@RequestParam`            | `@PathVariable`            |
| --------------- | -------------------------- | -------------------------- |
| **데이터 위치**      | URL 쿼리 파라미터 (`?key=value`) | URL 경로의 일부 (`/users/{id}`) |
| **주로 사용되는 상황**  | 검색 조건, 필터링, 페이징 등          | 리소스 식별                     |
| **필수 여부 설정 가능** | `required = true/false`    | N/A                        |