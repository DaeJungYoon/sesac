package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
//@NoArgsConstructor : 기본 생성자
//@AllArgsConstructor : 모든 필드에 대한 생성자
public class PostServiceJpaV4 {

    private final PostRepositoryJpaV4 postRepositoryJpaV4;

    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto){
//        requestDto -> post

//        PostV4 transientPost = requestDto.toEntity();
//        PostV4 persistedPost = postRepositoryJpaV4.save(transientPost);
        PostV4 post = postRepositoryJpaV4.save(requestDto.toEntity());
//      new PostResponseDto(post.getI(),post.getContent(), post.getAuthor())
        return PostResponseDto.from(post);

    }

}
