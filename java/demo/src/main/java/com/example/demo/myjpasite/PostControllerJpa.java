package com.example.demo.myjpasite;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
