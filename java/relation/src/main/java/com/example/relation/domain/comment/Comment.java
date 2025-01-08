package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.post.Post;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

//    post와의 연관관게
    // table : post_id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    public Comment update(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
        return this;
    }

    // comment create
    // 댓긍을 작성
    // 요청
        //URL - RESTful
            // posts/{post_id}/comment
        //method
            //post
        //data
            //content, post에 대한 정보
            //url
                // path variable
                    //post_id: 포스트에 대한 정보
                // request params
            //body
                // request body
                    //content
            // comment content, post_id, post...
}
