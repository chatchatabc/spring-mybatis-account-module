package com.example.demousermodule.user.services;

import com.example.demousermodule.user.dto.UserDto;
import com.example.demousermodule.user.entities.User;
import com.example.demousermodule.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class RegisterService implements IUserService {
    private UserRepository userRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistAuthenticationException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setDateCreated(LocalDate.EPOCH);
        user.setLastLogin(LocalDate.EPOCH);

        return userRepository.insert(user);
    }
    private boolean emailExists(String email) {
        return userRepository.findOne(email) != null;
    }
}
