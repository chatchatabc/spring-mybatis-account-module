package com.example.user.application.web;

import com.example.user.application.dto.UserRegisDto;
import com.example.user.domain.model.User;
import com.example.user.domain.service.RegisterService;
import com.example.user.impl.domain.UserAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SameReturnValue"})
@Controller
public class RegisController {


    @Autowired
    private RegisterService registerService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        UserRegisDto userRegisDto = new UserRegisDto();
        model.addAttribute("user", userRegisDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserRegisDto userRegisDto) {

        User user = new User();

        user.setUsername(userRegisDto.getUsername());
        user.setPassword(userRegisDto.getPassword());
        user.setEmail(userRegisDto.getEmail());
        user.setDateCreated(LocalDate.EPOCH);
        user.setLastLogin(LocalDate.EPOCH);
        System.out.println(user);
        try {
            if(userRegisDto.getPassword().equals(userRegisDto.getMatchingPassword())) registerService.registerNewUserAccount(user);
        } catch (UserAlreadyExistAuthenticationException uaeEx) {
            return "error";
        }

        return "redirect:/login";
    }
}
