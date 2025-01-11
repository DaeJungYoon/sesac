package com.example.whatisinyourmind;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String introduction;

    @OneToMany(mappedBy = "user")
    private List<User> users = new ArrayList<>();

    @Builder
    public Team(String name, String introduction) {
        this.name = name;
        this.introduction = introduction;
    }


}
