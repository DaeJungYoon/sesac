package com.example.relation.domain.post.dto;


import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.Post2;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Post2ListWithPageResponseDto {
    private List<Post2ResponseDto> posts;
    private long totalPages;
    private boolean hasNext;
    private boolean hasPrevious;

    public static Post2ListWithPageResponseDto from(Page<Post2> posts){
        return Post2ListWithPageResponseDto.builder()
                .posts(
                        posts.getContent().stream()
                                .map(
                                        Post2ResponseDto::from
                                ).toList()
                )
                .totalPages(posts.getTotalPages())
                .hasNext(posts.hasNext())
                .hasPrevious(posts.hasPrevious())
                .build();
    }

}
