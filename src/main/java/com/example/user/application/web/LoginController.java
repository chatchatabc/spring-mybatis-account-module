package com.example.user.application.web;

import com.example.user.domain.model.User;
import com.example.user.impl.domain.MyUserDetailsService;
import com.example.user.utils.error.AppErrorFactory;
import com.example.user.utils.error.AppErrorLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SameReturnValue"})
@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    private static final AppErrorLogger log = AppErrorFactory.getLogger(LoginController.class);
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String getByEmail(User loginUser) throws ServerException {
        UserDetails user = myUserDetailsService.loadUserByUsername(loginUser.getEmail());
        if (user == null) {
            log.error("APP-100-300", loginUser.getEmail());
            throw new ServerException("Email does not exist");
        } else {
            if(user.getPassword().equals(loginUser.getPassword())){
                return "homepage";
            }else{
                log.error("APP-200-300");
                throw new ServerException("Wrong Password");
            }
        }
    }
}
