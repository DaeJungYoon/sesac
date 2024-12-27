package com.example.demo.mysite.postMvc;

import com.example.demo.mysite.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private List<Post> posts = new ArrayList<>();
    private Long id = 0L;

    //저장, create 그 자체
    public Post save(Post newPost){
        String title = newPost.getTitle();
        String content = newPost.getContent();

        Post post = new Post(++id, title, content);
        posts.add(post);

        return post;
    }

    // 전체 게시물 조회
    public List<Post> findAll(){
        return posts;
    }

    // 단일 게시글
    public Post findById(Long id){
        for (Post post : posts){
            if(post.getId().equals(id)){
                return post;
            }
        }
        return null;
    }

    // 게시글 수정
    public Post modify(Long id, Post updatedPost){
        String title = updatedPost.getTitle();
        String content = updatedPost.getContent();
        for (Post post : posts) {
            if(post.getId().equals(id)){
//                post.setContent("수정된 제목");
//                post.setTitle("수정된 제목");
                post.setTitle(title);
                post.setContent(content);
                return post;
            }
        }
        return null;
    }

    // 게시글 삭제
    public void delete(Post post){
        posts.remove(post);
    }
}
