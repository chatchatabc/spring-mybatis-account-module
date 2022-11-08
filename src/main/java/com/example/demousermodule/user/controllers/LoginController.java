package com.example.demousermodule.user.controllers;

import com.example.demousermodule.user.entities.User;
import com.example.demousermodule.user.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> getbyEmail(@RequestBody User loginUser) throws ServerException {
        UserDetails user = myUserDetailsService.loadUserByUsername(loginUser.getEmail());
        if (user == null) {
            throw new ServerException("Can't resolve");
        } else {
            return new ResponseEntity<User>(loginUser, HttpStatus.OK);
        }
    }
}
