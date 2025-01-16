package com.example.relation.domain.user.dto.response;

import com.example.relation.domain.user.entity.Role;
import com.example.relation.domain.user.entity.User;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String username;
    private String email;
    private Role role;

    public static SignupResponseDto from(User entity){
        return SignupResponseDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }
}
