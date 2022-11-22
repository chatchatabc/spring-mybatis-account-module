package com.example.user.domain.service;

import com.example.user.domain.model.User;
import com.example.user.domain.repository.UserRepository;
import com.example.user.domain.specification.UserValidations;
import com.example.user.impl.domain.UserAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional
public class RegisterService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidations userValidations;

    @Override
    public int registerNewUserAccount(User user) throws UserAlreadyExistAuthenticationException {
        if (userValidations.emailExists(user.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("There is an account with that email address: "
                    + user.getEmail());
        }
         return userRepository.insert(user);
    }


}
