package com.example.springprac.myshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApi {
    // product를 데이터로서 저장을 하여 사용하고 싶어서
    // Product를 하나에 list에 저장을 함
    List<Product> products = new ArrayList<>();

    // home
    @GetMapping("/")
    public String homePage(){
        return "HOME SWEET HOME";
    }

    // Create
//    @GetMapping("/products/create")
//    public Product createProducts(){
//
//    }

    // read

    // update

    // delete

}
