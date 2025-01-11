package com.example.whatisinyourmind;

import com.example.whatisinyourmind.dto.response.UserUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    private int age;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Team team;

    @Builder
    public User(String username, String email, String nickname, int age) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
        this.isActive = true;
    }

    public User update(UserUpdateRequestDto requestDto){
        this.age = requestDto.getAge();
        this.email = requestDto.getEmail();
        this.nickname = requestDto.getNickname();
        this.isActive = requestDto.isActive();
        return this;
    }
}
