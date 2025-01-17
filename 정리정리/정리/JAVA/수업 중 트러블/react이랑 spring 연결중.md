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
**처음에 들은 원인(쉽게 생각)**
- 빈 배열에 넣어야하는 데 
이 빈 배열조차 없어 넣지를 못해서 생긴오류

**다시 생각하니 원인 이런 로직이 맞는 것 같음**
- Post에 있는 comments를 가져와야하는데 그 comments가 null이라 오류가 생겼다.
-> getComments라는 메서드를 실행하는데 가져오는 동작 자체가 null 이라 에러가 난거임?
좀 어색한데
- 메서드 실행 결과가  null인거 아닌가?
- 이 Null을 가지고 setPost와 같은 동작을 하려고 해서 오류가 발생
- 그니까 getComments() 할 때 null이 나오는 것은 문제가 안 되지만 이 Null을 가지고 setPost()해서 생긴 오류이다.
- NullPoint
