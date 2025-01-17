# 상황
```log
Error starting ApplicationContext.
To display the condition evaluation report re-run your application with 'debug' enabled.
2025-01-17T09:45:21.196+09:00 ERROR 17376 --- 
[relation] [  restartedMain] 
o.s.boot.SpringApplication               
: Application run failed

java.lang.NullPointerException:
Cannot invoke "java.util.List.add(Object)" 
because the return value of "com.example.relation.domain.post.entity.Post.getComments()" 
is null
```
react와 연결하는 도중 react서버에서 발생하는 오류가 원래 발생해야하는 오류와 다름

그래서 spring 서버를 보는데 서버가 꺼져있음

서버 실행 로그를 보니 저런 에러 메세지를 찾음

# 해결

**전**
```java
@BatchSize(size = 100)  
@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)  
private List<Comment> comments;
```

**후**
```java
@BatchSize(size = 100)  
@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)  
private List<Comment> comments = new ArrayList<>();
```
빈 배열에 넣어야하는 데 
이 빈 배열조차 없어 넣지를 못해서 생긴오류