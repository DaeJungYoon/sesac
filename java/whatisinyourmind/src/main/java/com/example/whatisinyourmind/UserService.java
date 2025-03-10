package com.example.whatisinyourmind;

import com.example.whatisinyourmind.dto.request.UserCreateRequestDto;
import com.example.whatisinyourmind.dto.response.UserListResponseDto;
import com.example.whatisinyourmind.dto.response.UserResponseDto;
import com.example.whatisinyourmind.dto.response.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public UserResponseDto getUserById(Long id){
        User user=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException());
        return UserResponseDto.from(user);
    }

    @Transactional
    public List<UserListResponseDto> getUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserListResponseDto::from)
                .toList();
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto requestDto){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException());
        user.update(requestDto);
        return UserResponseDto.from(user);
    }

    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException());
        userRepository.delete(user);
    }
}
