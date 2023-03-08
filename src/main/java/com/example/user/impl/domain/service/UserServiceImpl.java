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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


     UserRepository userRepository;
     UserValidations userValidations;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserValidations userValidations){
        this.userRepository = userRepository;
        this.userValidations = userValidations;
    }

    public User loadUserByEmail(String email, String password) throws UsernameNotFoundException {
        System.out.println(email);
        User user = userRepository.findUserByEmail(email);
        System.out.println(userRepository.findUserByEmail(email));
        ArrayList<String> role = new ArrayList<>();
        role.add("ADMIN");
        if (user == null) {
            return null;
        }
        user.setRoles(role);
        user.setIsEnabled(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsCredentialsNonExpired(true);

        return user;
    }

    public long registerNewUserAccount(User user) throws UserAlreadyExistAuthenticationException {
        if (userValidations.emailExists(user.getEmail())) {
            throw new UserAlreadyExistAuthenticationException("There is an account with that email address: "
                    + user.getEmail());
        }
        return userRepository.createUser(user);
    }

    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
