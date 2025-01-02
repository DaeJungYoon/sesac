package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import com.example.demo.myjpasitev4.dto.PostUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor
public class PostControllerJpaV4 {
    private final PostServiceJpaV4 postServiceJpaV4;

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostCreateRequestDto requestDto){
        return postServiceJpaV4.createPost(requestDto);
    }

    @GetMapping
    public List<PostListResponseDto> readPosts(){
        return postServiceJpaV4.readPosts();
    }
    @GetMapping("/{id}")
    public PostResponseDto readPostById(@PathVariable Long id){
        return postServiceJpaV4.readPostById(id);
    }
    // PUT id 제목 / 내용 dto data
    @PutMapping("{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postServiceJpaV4.updatePost(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postServiceJpaV4.deletePost(id);
    }

}
