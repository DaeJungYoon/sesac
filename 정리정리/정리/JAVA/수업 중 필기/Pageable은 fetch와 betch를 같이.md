```log
2025-01-13T14:13:53.360+09:00  WARN 26032 --- [relation] [nio-8080-exec-4] org.hibernate.orm.query                  
: HHH90003004: firstResult/maxResults specified with collection fetch; applying in memory

Hibernate: 
select p1_0.id,p1_0.author,c1_0.post_id,c1_0.id,c1_0.content,c1_0.created_at,c1_0.updated_at,p1_0.content,p1_0.created_at,p1_0.title,p1_0.updated_at 
from post p1_0 
left join comment c1_0 on p1_0.id=c1_0.post_id

Hibernate: 
select count(p1_0.id) 
from post p1_0 
left join comment c1_0 on p1_0.id=c1_0.post_id
```

```java
    @Query("SELECT p FROM Post p " +  
            "LEFT JOIN FETCH p.comments")  
//    @Query("SELECT p FROM Post p")  
    Page<Post> findPostWithCommentPage(Pageable pageable);
```


id 1 게시글 comments에 2개 있고 id 2 게시글 comments에 2개 있고
size 를 3 , page 0으로 요청 할 때
원래 버전에선 id 1 게시글 comments들이 다 나오고 id 2 게시글 comments 1개 까지 만 가져 오고
최신 버전은 이것을 메모리 상에서 처리를 하여 원하는 대로 page 0에 대한 원하는 모든 정보들을 가져올 수 있지만 성능상으로 좋지 않음

page는 fetch 랑 같이 못쓰고 쓸거면 betch랑 같이 사용해야 한다

```java
//    @Query("SELECT p FROM Post p " +  
//            "LEFT JOIN FETCH p.comments")  
    @Query("SELECT p FROM Post p")  
    Page<Post> findPostWithCommentPage(Pageable pageable);  
}
```
