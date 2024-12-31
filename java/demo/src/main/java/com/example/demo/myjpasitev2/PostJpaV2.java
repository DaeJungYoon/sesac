package com.example.demo.myjpasitev2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
//
    private String title;
    private String content;
//    // 여기까지 demodb와 연결될 준비가 됨
//
////     title, content에 대한 setter
//    public PostJpaV2 update(String title, String content){
//        this.title= title;
//        this.content = content;
//
//        return this;
//    }
}
