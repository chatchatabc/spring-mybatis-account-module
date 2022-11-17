package com.example.springmybatisaccountmodule.user.Domain.services;

import com.example.springmybatisaccountmodule.user.Application.dto.UserRegisDto;
import com.example.springmybatisaccountmodule.user.Impl.UserAlreadyExistAuthenticationException;

public interface IUserService {
    int registerNewUserAccount(UserRegisDto userRegisDto) throws UserAlreadyExistAuthenticationException;
}
