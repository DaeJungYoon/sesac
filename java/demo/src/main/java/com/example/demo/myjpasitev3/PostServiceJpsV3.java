package com.example.demo.myjpasitev3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceJpsV3 {
    private final PostRepositoryJpaV3 postRepositoryJpaV3;

    @Transactional
    public PostJpaV3 createPost(PostJpaV3 post){
        return postRepositoryJpaV3.save(post);
    }

    public List<PostJpaV3> getPosts(){
        return postRepositoryJpaV3.getPosts();
    }
}
