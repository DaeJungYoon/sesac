package com.example.demo.mysite.postMvc;

import com.example.demo.mysite.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mvc/posts")
public class PostController {
    PostService postService = new PostService();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost){
        return postService.createPost(newPost);
    }

    @GetMapping
    public List<Post> readPosts(){
        return postService.readPosts();
    }

    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id){
        return postService.readPostById(id);
    }

    @GetMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost){
        return postService.updatepost(id,updatedPost);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
