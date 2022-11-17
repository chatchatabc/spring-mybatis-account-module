package com.example.springmybatisaccountmodule.user.Domain.services;

import com.example.springmybatisaccountmodule.user.Domain.entities.User;
import com.example.springmybatisaccountmodule.user.Domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    UserRepository userRepository;

    public UserRepository getUser(User user) {
        return null;
    }
}
