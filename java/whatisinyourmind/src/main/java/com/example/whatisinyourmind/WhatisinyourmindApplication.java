package com.example.whatisinyourmind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WhatisinyourmindApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatisinyourmindApplication.class, args);
	}

}
