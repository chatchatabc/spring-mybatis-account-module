package com.example.demousermodule.user.controllers;

import com.example.demousermodule.user.dto.UserDto;
import com.example.demousermodule.user.entities.User;
import com.example.demousermodule.user.services.RegisterService;
import com.example.demousermodule.user.services.UserAlreadyExistAuthenticationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegisController {
    private RegisterService registerService;
    private ModelAndView mav;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                            HttpServletRequest request, Errors errors) {

        try {
            registerService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistAuthenticationException uaeEx) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }

        return new ModelAndView("successRegister", "user", userDto);
    }
}
