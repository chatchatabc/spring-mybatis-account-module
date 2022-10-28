package com.example.demousermodule;

import com.example.demousermodule.user.entities.User;
import com.example.demousermodule.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

@SpringBootApplication
public class DemoUserModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUserModuleApplication.class, args);

    }


    private final UserRepository userRepository;


    public DemoUserModuleApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner sampleCommandLineRunner() {
        return args -> {
            User user = new User();
            user.setUsername("josh");
            user.setPassword("123");
            user.setEmail("josh@josh.com");
            userRepository.createTable();
            userRepository.insert(user);
            System.out.println(this.userRepository.findOne(user.getEmail()));
        };
    }

}

