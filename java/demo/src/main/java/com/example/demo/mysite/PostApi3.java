package com.example.demo.mysite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v3/posts")
public class PostApi3 {
    // 게시글을 모아둔 하나의 테이블(엔티티) 라고 봐도 됨
    // post class의 instance, 즉 게시글을 넣을
    // List를 생성
    List<Post> posts = new ArrayList<>();
    private Long id = 0L; // 게시글 생성에서 id 생성을 위한 장치

    {
        //인스턴스를 생성
        posts.add(new Post(++id, "title", "content"));
    }

    // create
    // post / 내용 / url
    @PostMapping
    //restful
    // "/posts"
    public Post createPost(){
        Post post=new Post(++id, "title", "content");
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
    public Post updatePost(@PathVariable Long id){
        for (Post post : posts){
            if(post.getId().equals(id)){
                post.setTitle("수정된 제목");
                post.setContent("수정된 제목");
                return post;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    //
     // "/posts/{id}  / method : DELETE
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
}
