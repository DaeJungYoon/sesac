package com.example.relation.domain.post.dto;

import com.example.relation.domain.post.entity.Post2;
import com.example.relation.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post2CreateRequestDto {

    @NotBlank()
    @Length(max = 20)
    @Schema(
            description = "제목",
            example = "게시글 제목"
    )
    private String title;

    @Schema(
            description = "내용",
            example = "게시글 내용"
    )
    @NotBlank
    @Length(min = 5)
    private String content;

    public Post2 toEntity(User author) {
        return Post2.builder()
                .title(this.title)
                .content(this.content)
                .author(author)
                .build();
    }
}