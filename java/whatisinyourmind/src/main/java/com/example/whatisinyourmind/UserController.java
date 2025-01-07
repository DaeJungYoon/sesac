package com.example.whatisinyourmind;

import com.example.whatisinyourmind.dto.request.UserCreateRequestDto;
import com.example.whatisinyourmind.dto.response.UserListResponseDto;
import com.example.whatisinyourmind.dto.response.UserResponseDto;
import com.example.whatisinyourmind.dto.response.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createdUser(@RequestBody UserCreateRequestDto userCreateRequestDto){
        return userService.createdUser(userCreateRequestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserListResponseDto> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.updateUser(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
