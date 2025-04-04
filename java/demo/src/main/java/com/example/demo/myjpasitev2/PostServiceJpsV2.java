package com.example.demo.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceJpsV2 {
    private final PostRepositoryJpaV2 postRepositoryJpaV2;
//
    public PostJpaV2 createPost(PostJpaV2 post){
        return postRepositoryJpaV2.save(post);
    }

    public List<PostJpaV2> getPosts(){
        return postRepositoryJpaV2.getPosts();
    }

    public PostJpaV2 getPostById(Long id){
        return postRepositoryJpaV2.getPostById(id);
    }
//
    public PostJpaV2 updatePost(Long id, PostJpaV2 updatedPost){
        // 수정할 post를 찾아야 합니다.
//        PostJpaV2 post = postRepositoryJpaV2.getPostById(id).orElseThrow(()->new IllegalArgumentException("없는 Post 입니다"));
//
//        String title = updatePost.getTitle();
//        String content = updatePost.getContent();
//
//        post.update(title, content);
////        post.수정해.(title, content)를 가지고
//        return postRepositoryJpaV2.save(post);
//
////        return postRepositoryJpa.save(post.update(title,content));
        return postRepositoryJpaV2.update(id, updatedPost);

    }
    public void deletePost(Long id){
        postRepositoryJpaV2.delete(id);
    }
}
