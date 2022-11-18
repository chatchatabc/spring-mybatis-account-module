package com.example.springmybatisaccountmodule.user.domain.services;

import com.example.springmybatisaccountmodule.user.application.dto.UserRegisDto;
import com.example.springmybatisaccountmodule.user.domain.entities.User;
import com.example.springmybatisaccountmodule.user.domain.repositories.UserRepository;
import com.example.springmybatisaccountmodule.user.impl.UserAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class RegisterService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public int registerNewUserAccount(UserRegisDto userRegisDto) throws UserAlreadyExistAuthenticationException {
        if (emailExists(userRegisDto.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("There is an account with that email address: "
                    + userRegisDto.getEmail());
        }

        if(!userRegisDto.getPassword().equals(userRegisDto.getMatchingPassword())){
            throw new UserAlreadyExistAuthenticationException("Password doesn't match");
        }

        User user = new User();

        user.setUsername(userRegisDto.getUsername());
        user.setPassword(userRegisDto.getPassword());
        user.setEmail(userRegisDto.getEmail());
        user.setDateCreated(LocalDate.EPOCH);
        user.setLastLogin(LocalDate.EPOCH);

         return userRepository.insert(user);
    }
    private boolean emailExists(String email) {
        System.out.println(email);
        return userRepository.findOne(email) != null;
    }


}
