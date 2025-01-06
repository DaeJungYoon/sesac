package com.example.whatisinyourmind;

import com.example.whatisinyourmind.dto.request.UserCreateRequestDto;
import com.example.whatisinyourmind.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

}
