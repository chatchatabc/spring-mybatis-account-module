package com.example.demousermodule.user.services;

import com.example.demousermodule.user.dto.UserDto;
import com.example.demousermodule.user.entities.User;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistAuthenticationException;
}
