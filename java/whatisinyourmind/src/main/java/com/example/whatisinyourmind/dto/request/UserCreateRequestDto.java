package com.example.whatisinyourmind.dto.request;

import com.example.whatisinyourmind.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {
    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Length(min = 2, max = 20
            ,message = "이름은 2글자 이상 20글자 이하여야 합니다.")
    private String username;

    @NotBlank(message = "email은 필수 입력값입니다.")
    @Email(message = "abcde@email.com 형식에 맞게 입력해주세요")
    private String email;

    @NotBlank(message = "닉네임은 필수 입력값입니다.")
    @Length(min = 2, max = 10
            ,message = "닉네임은 2글자 이상 10글자 이하여야 합니다.")
    private String nickname;

    @Range(min = 0, max = 150
            ,message = "0~150 범위 내의 숫자를 입력해주세요")
    private int age;

    @NotBlank(message = "활성화 여부는 필수 입력값입니다.")
    private boolean isActive;

    public User toEntity(){
        return User.builder()
                .username(this.username)
                .email(this.email)
                .nickname(this.nickname)
                .age(this.age)
                .isActive(this.isActive)
                .build();
    }
}
