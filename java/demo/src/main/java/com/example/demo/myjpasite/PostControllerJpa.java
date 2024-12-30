package com.example.demo.myjpasite;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/posts")
public class PostControllerJpa {
    private final PostServiceJps postServiceJps;

    public PostControllerJpa(PostServiceJps postServiceJps) {
        this.postServiceJps = postServiceJps;
    }

    @PostMapping
    public PostJpa createPost(@RequestBody PostJpa newPost){
        return postServiceJps.createPost(newPost);
    }

    @GetMapping
    public List<PostJpa> getPosts(){
        return postServiceJps.getPosts();
    }

    @GetMapping("/{id}")
    public PostJpa getPostById(@PathVariable Long id){
        return postServiceJps.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostJpa updatePost(@PathVariable Long id, @RequestBody PostJpa updatedPost){
        return postServiceJps.updatePost(id, updatedPost);
    }
}
