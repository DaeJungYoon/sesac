package com.example.relation.domain.post.dto;


import com.example.relation.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
public class PostListWithPageResponseDto {
    private List<PostListResponseDto> posts;
    private long totalPages;
    private boolean hasNext;
    private boolean hasPrevious;

    public static PostListWithPageResponseDto from(Page<Post> posts){
        return PostListWithPageResponseDto.builder()
                .posts(
                        posts.getContent().stream()
                                .map(
                                        PostListResponseDto::from
                                ).toList()
                )
                .totalPages(posts.getTotalPages())
                .hasNext(posts.hasNext())
                .hasPrevious(posts.hasPrevious())
                .build();
    }
}
