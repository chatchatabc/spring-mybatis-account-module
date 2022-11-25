package com.example.user.domain.service;

import com.example.user.domain.model.User;
import com.example.user.impl.domain.UserAlreadyExistAuthenticationException;

public interface UserService {
    long registerNewUserAccount(User user) throws UserAlreadyExistAuthenticationException;
}
