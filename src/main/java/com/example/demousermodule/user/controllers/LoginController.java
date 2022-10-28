package com.example.demousermodule.user.controllers;

import com.example.demousermodule.user.entities.User;
import com.example.demousermodule.user.securities.SecSecurityConfig;
import com.example.demousermodule.user.services.AppInitializer;
import com.example.demousermodule.user.services.LoginService;
import com.example.demousermodule.user.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {


    MyUserDetailsService myUserDetailsService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<User> getbyEmail(String email){
        UserDetails user = myUserDetailsService.loadUserByUsername(email);

            return new ResponseEntity<>(HttpStatus.OK);

    }
}
