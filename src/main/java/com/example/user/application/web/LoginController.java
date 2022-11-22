package com.example.user.application.web;

import com.example.user.domain.model.User;
import com.example.user.impl.domain.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService myUserDetailsService;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String getByEmail(User loginUser) throws ServerException {
        UserDetails user = myUserDetailsService.loadUserByUsername(loginUser.getEmail());
        System.out.println(loginUser.getEmail());
        if (user == null) {
            throw new ServerException("Email does not exist");
        } else {
            if(user.getPassword().equals(loginUser.getPassword())){
                return "redirect:/homepage";
            }else{
                throw new ServerException("Wrong Password");
            }
        }
    }
}
