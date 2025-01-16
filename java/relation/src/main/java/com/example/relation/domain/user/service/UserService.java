package com.example.relation.domain.user.service;

import com.example.relation.domain.user.dto.response.SignupResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.domain.user.UserRepository;
import com.example.relation.domain.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SignupResponseDto getMyProfile(User user){
        return UserResponseDto.from(user);
    }
}
