package com.example.whatisinyourmind.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String email;
    private String nickname;
    private int age;
    private boolean isActive;

}
