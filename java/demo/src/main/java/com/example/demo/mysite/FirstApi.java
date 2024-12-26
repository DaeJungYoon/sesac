package com.example.demo.mysite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApi {
    @GetMapping("/")
    public String mainPage(){
        return "hello spring";
    }
    @GetMapping("/hello")
    public String helloPage(){
        return "Hello User";
    }
}
