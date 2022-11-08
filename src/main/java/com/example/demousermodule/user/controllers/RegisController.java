package com.example.demousermodule.user.controllers;

import com.example.demousermodule.user.dto.UserDto;
import com.example.demousermodule.user.entities.User;
import com.example.demousermodule.user.services.RegisterService;
import com.example.demousermodule.user.services.UserAlreadyExistAuthenticationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                            HttpServletRequest request, Errors errors) {

        try {
            registerService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistAuthenticationException uaeEx) {
            return "An account for that username/email already exists.";
        }

        return "redirect:/registration";
    }
}
