package com.example.whatisinyourmind.dto.response;

import com.example.whatisinyourmind.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserListResponseDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    private final String nickname;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    public static UserListResponseDto from(User entity){
        return UserListResponseDto.builder()
                .id(entity.getId())
                .nickname(entity.getNickname())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
