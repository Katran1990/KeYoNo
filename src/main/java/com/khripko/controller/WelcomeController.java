package com.khripko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
}
