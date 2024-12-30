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

    public PostJpa updatePost(Long id, PostJpa updatePost){
        // 수정할 post를 찾아야 합니다.
        PostJpa post = postRepositoryJpa.findById(id).orElseThrow(()->new IllegalArgumentException("없는 Post 입니다"));

        String title = updatePost.getTitle();
        String content = updatePost.getContent();

        post.update(title, content);
//        post.수정해.(title, content)를 가지고
        return postRepositoryJpa.save(post);

//        return postRepositoryJpa.save(post.update(title,content));
    }
}
