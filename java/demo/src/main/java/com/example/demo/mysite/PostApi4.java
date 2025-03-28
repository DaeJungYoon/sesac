package com.example.demo.mysite;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v4/posts")
public class PostApi4 {
    // 게시글을 모아둔 하나의 테이블(엔티티) 라고 봐도 됨
    // post class의 instance, 즉 게시글을 넣을
    // List를 생성
    List<Post> posts = new ArrayList<>();
    private Long id = 0L; // 게시글 생성에서 id 생성을 위한 장치

    {
        //인스턴스를 생성
        posts.add(new Post(++id, "prime title", "prime content"));
    }

    // create
    // post / 내용 / url
    @PostMapping
    //restful
    // "/posts"
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost){
//        title = 입력 받은  title
//        content = 입력 받은 title
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());

        String title = newPost.getTitle();
        String content = newPost.getContent();
        if(title == null || title.isBlank()){
            throw new RuntimeException("title을 입력해주세요");
        }

        if(content == null || content.isBlank()){
            throw new IllegalArgumentException("content를 입력해주세요");
        }
//        Post post=new Post(++id, "title", "content");
        Post post=new Post(++id,title, content);
        posts.add(post);

        return post;
    }

    // read = 전체 조회
    // posts / get
    @GetMapping
    public List<Post> readPosts(){
    return posts;
    }

    // read - 단일 조회
//    @GetMapping("/posts/{postId}")
//    public Post readPostById(@PathVariable("postId") Long id){
    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id){
        //posts에서 post를 가져오자.
        for(Post post: posts){
            if(post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }
    // update
    // 변경 내용 / id / url
    // restful
    // "/posts/{id}" / method : PUT(전체) / PATCH
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post editPost){
        String title = editPost.getTitle();
        String content = editPost.getContent();
        for (Post post : posts){
            if(post.getId().equals(id)){
//                post.setContent("수정된 제목");
//                post.setTitle("수정된 제목");
                post.setTitle(title);
                post.setContent(content);
                return post;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    //
     // "/posts/{id}  / method : DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Post deletePost(@PathVariable Long id){
        Post removedPost = null;
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                removedPost = post;
                break;
            }
        }
        posts.remove(removedPost);
        return null;
    }

//    @GetMapping("/paged") // "/paged?key=value..."
//    public List<Post> getPagedPosts(@RequestParam String key){
//        System.out.println(key);
//        return posts;
//    }
//    @GetMapping("/paged")
//    public List<Post> getPagedPosts(@RequestParam int page, @RequestParam int size){
//        // 1. 페이지네이션을 위한 더미데이터 추가
//        for (int i = 1; i <= 20; i++) {
//            String title = "제목 " + i;
//            String content = "내용 " + i;
//            Post post = new Post(++id, title, content);
//            posts.add(post);
//        }
//        // 2. 시작 인덱스와 끝 인덱스 계산
//        int startIndex = (page - 1) * size;
//        int endIndex = Math.min(startIndex + size, posts.size());
//
//        // 3. 페이지에 해당하는 데이터만 추출
//        return posts.subList(startIndex, endIndex);
//    }
    @GetMapping("/paged")
    public List<Post> getPagedPosts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ){

        // 1. 페이지네이션을 위한 더미데이터 추가
        for (int i = 1; i <= 20; i++) {
            String title = "제목 " + i;
            String content = "내용 " + i;
            Post post = new Post(++id, title, content);
            posts.add(post);
        }

        // 2. 시작 인덱스와 끝 인덱스 계산
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, posts.size());

        // 3. 페이지에 해당하는 데이터만 추출
        return posts.subList(startIndex, endIndex);
    }
}
