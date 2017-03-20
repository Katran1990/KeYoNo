package com.khripko.controller;

import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userService;

    @GetMapping("/users")
    public String getNotesPage(Model model, HttpServletRequest request){
        model.addAttribute("users", userService.readAll());
        return "users";
    }
}
