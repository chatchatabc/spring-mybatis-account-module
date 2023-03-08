package com.example.user.application.web;

import com.example.user.application.commons.vo.UserRegisVO;
import com.example.user.domain.model.User;
import com.example.user.domain.service.UserService;
import com.example.user.impl.domain.error.UserAlreadyExistAuthenticationException;
import com.example.user.utils.error.AppErrorFactory;
import com.example.user.utils.error.AppErrorLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.rmi.ServerException;
import java.time.LocalDate;

@Controller
public class UserController {


    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private static final AppErrorLogger log = AppErrorFactory.getLogger(UserController.class);
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String authUser(User loginUser, Model model) throws ServerException {
        User user = userService.loadUserByEmail(loginUser.getEmail(), loginUser.getPassword());
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

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserRegisVO userRegisVO = new UserRegisVO();
        model.addAttribute("user", userRegisVO);
        return "registration";
    }

    @PostMapping("/register-submit")
    public String registerUserAccount(UserRegisVO userRegisVO, Model model) {

        User user = new User();

        user.setUsername(userRegisVO.getUsername());
        user.setPassword(userRegisVO.getPassword());
        user.setEmail(userRegisVO.getEmail());
        user.setDateCreated(LocalDate.EPOCH);
        user.setLastLogin(LocalDate.EPOCH);

        try {
            if(userRegisVO.getPassword().equals(userRegisVO.getMatchingPassword())){
                model.addAttribute("user", userService.registerNewUserAccount(user));
                return "homepage";
            }
            return "registration";
        } catch (UserAlreadyExistAuthenticationException uaeEx) {
            return "error";
        }
    }
}
