package com.example.springmybatisaccountmodule;

import com.example.springmybatisaccountmodule.user.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springmybatisaccountmodule {

    public static void main(String[] args) {
        SpringApplication.run(Springmybatisaccountmodule.class, args);

    }


    private final UserRepository userRepository;


    public Springmybatisaccountmodule(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner sampleCommandLineRunner() {
        return args -> {
           userRepository.createTable();
        };
    }


}

