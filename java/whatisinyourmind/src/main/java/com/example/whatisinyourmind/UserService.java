package com.example.whatisinyourmind;

import com.example.whatisinyourmind.dto.request.UserCreateRequestDto;
import com.example.whatisinyourmind.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createdUser(UserCreateRequestDto userCreateRequestDto){
        User user = userRepository.save(userCreateRequestDto.toEntity());
        return UserResponseDto.from(user);
    }
}
