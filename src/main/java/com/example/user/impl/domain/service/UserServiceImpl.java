package com.example.user.impl.domain.service;

import com.example.user.domain.model.User;
import com.example.user.domain.repository.UserRepository;
import com.example.user.domain.service.UserService;
import com.example.user.domain.specification.UserValidations;
import com.example.user.impl.domain.error.UserAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {


     UserRepository userRepository;
     UserValidations userValidations;

     PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserValidations userValidations, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userValidations = userValidations;
    }

    public User loadUserByEmail(String email, String password) throws UsernameNotFoundException {
        System.out.println(email);
        User user = this.loadUserByUsername(email);

        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new UsernameNotFoundException("Wrong Password");
        }

        return user;
    }

    public User registerNewUserAccount(User user) throws UserAlreadyExistAuthenticationException, ServerException {
        if (userValidations.emailExists(user.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("There is an account with that email address: "
                    + user.getEmail());
        }
        if(userRepository.createUser(user) == 1){
            return userRepository.findUserByEmail(user.getEmail());
        }
        throw new ServerException("Something went wrong");
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        user.setIsEnabled(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsCredentialsNonExpired(true);

        return user;
    }
}
