package com.example.demo.myjpasite;

import org.springframework.stereotype.Service;

@Service
public class PostServiceJps {
    private final PostRepositoryJpa postRepositoryJpa;


    public PostServiceJps(PostRepositoryJpa postRepositoryJpa) {
        this.postRepositoryJpa = postRepositoryJpa;
    }

    public PostJpa createPost(PostJpa post){
        return postRepositoryJpa.save(post);
    }
}
