package com.khripko.controller;

import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/users")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("users");
        List<UserDetails> users = userDetailsService.readAll();
        modelAndView.addObject(users);
        return modelAndView;
    }
}
