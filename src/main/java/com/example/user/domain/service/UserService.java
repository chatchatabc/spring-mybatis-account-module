package com.example.user.domain.service;

import com.example.user.domain.model.User;
import com.example.user.impl.domain.error.UserAlreadyExistAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    long registerNewUserAccount(User user) throws UserAlreadyExistAuthenticationException;

    User loadUserByEmail(String email, String password);

}
