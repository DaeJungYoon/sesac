package com.example.demo.myjpasitev4.dto;

import com.example.demo.myjpasitev4.PostV4;
import lombok.Getter;
import lombok.NoArgsConstructor;

// title, content, author를 받아다가
// 우리의 Post로 만드는 역할을 하겠어
@Getter
//@NoArgsConstructor // 있든 없든 상관 없지만 명시적으로는 있는 것이 좋을 듯
// 필요하지만 이경우는 기본 생성자를
public class PostUpdateRequestDto {
    private String title;
    private String content;
    private String author;

//
//    public PostV4 toEntity(){
//        return PostV4.builder()
//                .title(this.title)
//                .content(this.content)
//                .build();
////        return new PostV4(title,content,author); 이거랑 동일
//    }
}
