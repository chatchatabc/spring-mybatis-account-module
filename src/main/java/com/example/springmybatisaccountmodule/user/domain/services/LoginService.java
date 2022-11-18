package com.example.springmybatisaccountmodule.user.domain.services;

import com.example.springmybatisaccountmodule.user.domain.entities.User;
import com.example.springmybatisaccountmodule.user.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    UserRepository userRepository;

    public UserRepository getUser(User user) {
        return null;
    }
}
