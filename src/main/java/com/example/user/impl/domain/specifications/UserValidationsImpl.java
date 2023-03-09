package com.example.user.impl.domain.specifications;

import com.example.user.domain.repository.UserRepository;
import com.example.user.domain.specification.UserValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class UserValidationsImpl implements UserValidations {


    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean emailExists(String email) {
        return userRepository.findUserByEmail(email) != null;
    }
}
