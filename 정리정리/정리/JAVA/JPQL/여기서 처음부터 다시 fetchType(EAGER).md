### Read - 전체 이거 해보면서 하는 거임

- 위의 예시는 게시글을 1개만 가져오기 때문에 N+1 문제를 해결하였지만 체감되지 않는다.
    
- List조회를 통해 최적화의 과정을 체감해보자
    
- `PostController`
    
    ```java
    @GetMapping("/detail")
    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2 >>> readPostsDetail(){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsDetail()
        ));
    }
    ```
    
- `PostService`
    
    ```java
    public List<PostWithCommentAndTagResponseDtoV2 > readPostsDetail(){
    
        return postRepository.findWithCommentAndTag().stream()
                .map(PostWithCommentAndTagResponseDtoV2 ::from)
                .toList();
    }
    ```
    
- `PostRepository`
    
    - batch size 옵션에 따라 생성되는 쿼리의 양을 비교해보자.
    
    ```java
    @Query("SELECT p FROM Post p " +
            "LEFT JOIN  p.comments " +
            "LEFT JOIN  p.postTags pt " +
            "LEFT JOIN  pt.tag ")
    List<Post> findWithCommentAndTag();
    ```
    
    - 추가로, 아래의 쿼리를 실행하며 fetch join을 했을때와 안했을때의 차이를 알아보자
        
        ```java
        @Query("SELECT DISTINCT p FROM Post p " +
                "LEFT JOIN  p.comments " +
                "LEFT JOIN FETCH  p.postTags pt " +
                "LEFT JOIN FETCH pt.tag ")
        List<Post> findWithCommentAndTag();
        ```
        
        - 단, fetch join을 했을 때 카타시안 곱이 발생할 수 있기 때문에 조심해야 한다.