package com.example.demo.myjpasitev4;

import com.example.demo.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.myjpasitev4.dto.PostResponseDto;
import com.example.demo.myjpasitev4.dto.PostUpdateRequestDto;
import com.example.demo.myjpasitev4.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PostListResponseDto> readPosts(){
        return postRepositoryJpaV4.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
//                .collect(Collectors.toCollection(list));
//                .map((post)->PostListResponseDto.from(post));
    }

    public PostResponseDto readPostById(Long id){
        PostV4 post = postRepositoryJpaV4.findById(id)
                .orElseThrow(()->new ResourceNotFoundException());
        return PostResponseDto.from(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto){
//        수정에 대한 로직
//        하나 가져오자 -> 걔를 수정하자 -> save하자
        PostV4 post = postRepositoryJpaV4.findById(id)
                .orElseThrow(()->new IllegalArgumentException());
        post.update(requestDto);
        return PostResponseDto.from(post);
    }

    @Transactional()
    public void deletePost(Long id){
//        삭제에 대한 로직
//        하나 가져오자 -> 걔를  삭제하자
        PostV4 post = postRepositoryJpaV4.findById(id)
                .orElseThrow(()->new IllegalArgumentException());
        postRepositoryJpaV4.delete(post);
    }

}
