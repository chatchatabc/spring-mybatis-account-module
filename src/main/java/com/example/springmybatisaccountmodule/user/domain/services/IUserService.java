package com.example.springmybatisaccountmodule.user.domain.services;

import com.example.springmybatisaccountmodule.user.application.dto.UserRegisDto;
import com.example.springmybatisaccountmodule.user.impl.UserAlreadyExistAuthenticationException;

public interface IUserService {
    int registerNewUserAccount(UserRegisDto userRegisDto) throws UserAlreadyExistAuthenticationException;
}
