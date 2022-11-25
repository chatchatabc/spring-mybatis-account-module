package com.example.user.application.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("SameReturnValue")
@Controller
public class HomeController {

    @GetMapping("/homepage")
    public String login(){
        return "homepage";
    }
}
