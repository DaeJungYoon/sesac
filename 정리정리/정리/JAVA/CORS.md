CORS(Cross-Origin Resource Sharing)는 웹 브라우저에서 **도메인 간 리소스 요청을 허용하거나 제한**하는 보안 메커니즘입니다. 기본적으로 웹 브라우저는 보안상의 이유로, 동일 출처(Same-Origin) 정책을 적용하여 다른 도메인, 프로토콜, 또는 포트에서 오는 요청을 차단합니다. 그러나 CORS를 통해 이 제한을 완화할 수 있습니다.

---

### CORS의 주요 개념

1. **Same-Origin Policy (SOP)**
    
    - 브라우저의 기본 보안 정책으로, 같은 출처에서 로드된 리소스만 상호작용할 수 있도록 제한합니다.
    - 예:
        - 동일 출처: `https://example.com`에서 `https://example.com/api` 요청 가능
        - 다른 출처: `https://example.com`에서 `https://api.example.com` 요청 불가 (포트가 다름)
2. **Cross-Origin 요청**
    
    - 한 출처의 웹 페이지가 다른 출처에 리소스를 요청할 때 발생합니다.
    - 예:
        - `https://example.com`에서 `https://api.other.com`으로 데이터 요청
    - CORS가 허용되면 브라우저가 이 요청을 승인할 수 있습니다.

---

### CORS의 작동 방식

서버가 HTTP 응답 헤더를 통해 브라우저에 특정 출처의 요청을 허용한다는 정보를 전달합니다.

#### 주요 헤더

1. **`Access-Control-Allow-Origin`**
    
    - 요청을 허용할 출처를 지정합니다.
    - 예: `Access-Control-Allow-Origin: https://example.com`  
        또는 모든 출처 허용: `Access-Control-Allow-Origin: *`
2. **`Access-Control-Allow-Methods`**
    
    - 허용할 HTTP 메서드를 지정합니다.
    - 예: `Access-Control-Allow-Methods: GET, POST`
3. **`Access-Control-Allow-Headers`**
    
    - 요청 시 사용할 수 있는 헤더를 지정합니다.
    - 예: `Access-Control-Allow-Headers: Content-Type, Authorization`

---

### CORS 요청의 유형

1. **단순 요청(Simple Request)**
    
    - GET, POST, HEAD와 같은 기본 메서드로 이루어진 요청.
    - 브라우저는 서버 응답에 `Access-Control-Allow-Origin`만 확인합니다.
2. **프리플라이트 요청(Preflight Request)**
    
    - OPTIONS 메서드를 사용하여 실제 요청 전에 서버가 요청을 허용하는지 확인합니다.
    - 복잡한 요청(예: `PUT` 메서드, 사용자 정의 헤더 포함)에서 사용됩니다.

---

### CORS 문제 해결 방법

1. **서버에서 허용 설정 추가**
    
    - 서버가 올바른 CORS 헤더를 반환하도록 구성.
    - 예: Node.js Express 서버에서:   
```java
const cors = require('cors');
app.use(cors({ origin: 'https://example.com' }));
```
        
2. **프록시 서버 사용**
    
    - 클라이언트와 API 서버 사이에 프록시 서버를 두어 같은 출처로 요청을 우회.

---

### 요약

CORS는 웹 애플리케이션의 보안을 강화하면서도 유연하게 도메인 간 데이터 요청을 허용하는 메커니즘입니다. 서버에서 적절히 구성하면, 안전하게 다른 출처의 리소스와 상호작용할 수 있습니다.