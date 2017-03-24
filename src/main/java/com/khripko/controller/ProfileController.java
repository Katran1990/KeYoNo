package com.khripko.controller;

import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    UserDetailsService userService;

    @GetMapping("/profile")
    public String getProfile(HttpServletRequest request, Model model){
        model.addAttribute("user", userService.read((Long) request.getSession().getAttribute("currentUserId")));
        return "profile";
    }
}
