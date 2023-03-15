package com.example.user.domain.service;

import com.example.user.domain.model.User;
import com.example.user.impl.domain.error.UserAlreadyExistAuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.rmi.ServerException;

public interface UserService extends UserDetailsService {

    User registerNewUserAccount(User user) throws UserAlreadyExistAuthenticationException, ServerException;

    User processUser(String email, String password);

}
