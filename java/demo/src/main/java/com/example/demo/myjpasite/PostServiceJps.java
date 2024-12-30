package com.example.demo.myjpasite;

import com.example.demo.mysite.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJps {
    private final PostRepositoryJpa postRepositoryJpa;


    public PostServiceJps(PostRepositoryJpa postRepositoryJpa) {
        this.postRepositoryJpa = postRepositoryJpa;
    }

    public PostJpa createPost(PostJpa post){
        return postRepositoryJpa.save(post);
    }

    public List<PostJpa> getPosts(){
        return postRepositoryJpa.findAll();
    }

    public PostJpa getPostById(Long id){
        return postRepositoryJpa.findById(id)
                .orElseThrow(
                        ()->new IllegalArgumentException("없는 id 입니다."));
    }
}
