package com.example.demo.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v2/posts")
@RequiredArgsConstructor
public class PostControllerJpaV2 {
    private final PostServiceJpsV2 postServiceJpsV2;

    @PostMapping
    public PostJpaV2 createPost(@RequestBody PostJpaV2 newPost){
        return postServiceJpsV2.createPost(newPost);
    }

    @GetMapping
    public List<PostJpaV2> getPosts(){
        return postServiceJpsV2.getPosts();
    }

    @GetMapping("/{id}")
    public PostJpaV2 getPostById(@PathVariable Long id){
        return postServiceJpsV2.getPostById(id);
    }
//
    @PutMapping("/{id}")
    public PostJpaV2 updatePost(@PathVariable Long id, @RequestBody PostJpaV2 updatedPost){
        return postServiceJpsV2.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postServiceJpsV2.deletePost(id);
    }
}
