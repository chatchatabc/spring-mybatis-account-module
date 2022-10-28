package com.example.demousermodule.user.services;

import com.example.demousermodule.user.entities.User;
import com.example.demousermodule.user.repositories.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    UserRepository userRepository;


    public UserRepository getUser(User user) {
        return null;
    }
}
