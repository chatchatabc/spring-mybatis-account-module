package com.example.user.application.web;

import com.example.user.application.commons.mapper.UserMapper;
import com.example.user.application.commons.vo.UserVO;
import com.example.user.domain.model.User;
import com.example.user.domain.service.UserService;
import com.example.user.utils.error.AppErrorFactory;
import com.example.user.utils.error.AppErrorLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@SuppressWarnings({"SameReturnValue", "PlaceholderCountMatchesArgumentCount"})
@Controller
public class UserController {


    final UserService userService;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    private static final AppErrorLogger log = AppErrorFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String showLoginFormRedirect(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/authenticate")
    public String authUser(UserVO userVO, Model model) {
        try{
            if(userVO.getEmail().isEmpty() || userVO.getPassword().isEmpty() ){
                return "login";
            }
            System.out.println(userVO);
            model.addAttribute("user", userService.processUser(userVO.getEmail(), userVO.getPassword()));
            return "homepage";
        }catch (Exception e){
            log.error("APP-100-300", userVO.getEmail());
            System.out.println(e.getMessage());
            return "error";

        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserVO userVO = new UserVO();
        model.addAttribute("user", userVO);
        return "registration";
    }

    @PostMapping("/register-submit")
    public String registerUserAccount(UserVO userVO, Model model) {
        try {
            if(userVO.getPassword().equals(userVO.getMatchingPassword())){
                User user = UserMapper.INSTANCE.voToModel(userVO);

                model.addAttribute("user", userService.registerNewUserAccount(user));
                return "homepage";
            }
            return "registration";
        } catch (Exception e) {
            return "error";
        }
    }
}
