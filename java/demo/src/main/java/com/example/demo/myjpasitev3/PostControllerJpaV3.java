package com.example.demo.myjpasitev3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v3/posts")
@RequiredArgsConstructor
public class PostControllerJpaV3 {
    private final PostServiceJpsV3 postServiceJpsV3;


    @PostMapping
    public PostJpaV3 createPost(@RequestBody PostJpaV3 newPost) {
        return postServiceJpsV3.createPost(newPost);
    }

    @GetMapping
    public List<PostJpaV3> getPosts(){
        return postServiceJpsV3.getPosts();
    }

//    @GetMapping("/{id}")
//    public PostJpaV3 getPostById(@PathVariable Long id){
//        return postServiceJpsV3.getPostById(id);
//    }
////
//    @PutMapping("/{id}")
//    public PostJpaV3 updatePost(@PathVariable Long id, @RequestBody PostJpaV3 updatedPost){
//        return postServiceJpsV3.updatePost(id, updatedPost);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePost(@PathVariable Long id){
//        postServiceJpsV3.deletePost(id);
//    }
}
