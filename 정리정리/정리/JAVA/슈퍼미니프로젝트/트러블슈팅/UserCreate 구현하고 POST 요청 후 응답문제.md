# 문제 상황
POST 요청 후 나와야 할 생성시간과 업데이트 시간이 나오지 않음 
기존 코드
```java
//com.example.Whatisinyourmind/WhatisinyourmindApplication
package com.example.whatisinyourmind;  
  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;  
  
@SpringBootApplication  
public class WhatisinyourmindApplication {  
  
    public static void main(String[] args) {  
       SpringApplication.run(WhatisinyourmindApplication.class, args);  
    }  
  
}
```

```json
 { 
	"id": 4, 
   "username": "준김김", 
   "email": "sdfasdf@naver.com", 
   "nickname": "구구진", 
   "age": 23, 
   "createdAt": null, 
   "updatedAt": null 
}
```

# 해결 후 
perplexity 사용해서 JPA Auditing 설정 누락인 것을 확인
@EnableJpaAuditing 적용하고 실행하니 정상적으로 응답이 옴
```java
//com.example.Whatisinyourmind/WhatisinyourmindApplication
package com.example.whatisinyourmind;  
  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;  
  
@EnableJpaAuditing  
@SpringBootApplication  
public class WhatisinyourmindApplication {  
  
    public static void main(String[] args) {  
       SpringApplication.run(WhatisinyourmindApplication.class, args);  
    }  
  
}
```

```json
{

    "id": 5,

    "username": "준김김",

    "email": "sdfasdf@naver.com",

    "nickname": "구구진",

    "age": 23,

    "createdAt": "2025-01-06T19:30:00.2609349",

    "updatedAt": "2025-01-06T19:30:00.2609349"

}
```

# 회고
- 한 번도 안 써본 것을 사용할 때 그것의 사용방법을 꼼꼼히 읽고 코드 작성해야겠다라고 생각