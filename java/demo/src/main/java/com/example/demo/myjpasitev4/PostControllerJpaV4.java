package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jap/v4/posts")
@RequiredArgsConstructor
public class PostControllerJpaV4 {
    private final PostServiceJpaV4 postServiceJpaV4;

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostCreateRequestDto requestDto){
        return postServiceJpaV4.createPost(requestDto);
    };
}
