package com.example.springmybatisaccountmodule.user.Application.controllers;

import com.example.springmybatisaccountmodule.user.Application.dto.UserRegisDto;
import com.example.springmybatisaccountmodule.user.Domain.services.RegisterService;
import com.example.springmybatisaccountmodule.user.Impl.UserAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserRegisDto userRegisDto = new UserRegisDto();
        model.addAttribute("user", userRegisDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(UserRegisDto userRegisDto,
                                      HttpServletRequest request, Errors errors) {
        try {
            registerService.registerNewUserAccount(userRegisDto);
        } catch (UserAlreadyExistAuthenticationException uaeEx) {
            return "An account for that username/email already exists";
        }

        return "redirect:/login";
    }
}
