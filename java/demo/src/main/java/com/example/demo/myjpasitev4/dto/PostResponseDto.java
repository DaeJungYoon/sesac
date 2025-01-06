package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
//    public PostResponseDto(PostV4 entity) {
//        this(entity.getId(),...)
//    }
//    이렇게 가능은 함

    public static PostResponseDto from(PostV4 entity){
//        return new PostResponseDto(entity.getI(),entity.getContent(), entity.getAuthor())
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .author(entity.getAuthor())
                .build();

    }

}
