package com.example.relation.domain.comment.dto;

import com.example.relation.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentResponseDto {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;

    public static CommentResponseDto from(Comment entity){
        return CommentResponseDto.builder()
                .content(entity.getContent())
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .build();
    }



}
