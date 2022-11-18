package com.example.springmybatisaccountmodule.user.application.controllers;

import com.example.springmybatisaccountmodule.user.domain.entities.User;
import com.example.springmybatisaccountmodule.user.domain.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService myUserDetailsService;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String getbyEmail(User loginUser) throws ServerException {
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
