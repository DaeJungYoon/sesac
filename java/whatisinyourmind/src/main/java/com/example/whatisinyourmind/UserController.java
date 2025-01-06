package com.example.whatisinyourmind;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserController {
    @Column(nullable = false)
    @NotBlank
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    private int age;

    @Column(nullable = false)
    private boolean isActive;
}
