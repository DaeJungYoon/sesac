package com.example.demo.mysite.postMvc;

import com.example.demo.mysite.Post;

import java.util.List;

public class PostService {
    PostRepository postRepository = new PostRepository();

    // 컨트롤러에게서 data를 입력받아서
    public Post createPost(Post newPost){

        // validation 체크를 한 후에 - 비즈니스 로직처리, 내가 할 것 할게.
        String title = newPost.getTitle();
        String content = newPost.getContent();

        if(title == null || title.isBlank()){
            throw new RuntimeException("title을 입력해주세요");
        }

        if(content == null || content.isBlank()){
            throw new IllegalArgumentException("content를 입력해주세요");
        }

        // post를 생성하겠다.
        return postRepository.save(newPost);
    }

    //
    public List<Post> readPosts(){
        return postRepository.findAll();
    }

    public Post readPostById(Long id){
        Post post = postRepository.findById(id);
        if(post == null){
            throw new IllegalArgumentException("none id");
        }
        return post;
    }
}
