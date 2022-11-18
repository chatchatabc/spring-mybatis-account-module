package com.example.springmybatisaccountmodule.user.Application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/homepage")
    public String login(){
        return "homepage";
    }
}
