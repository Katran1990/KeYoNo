package com.khripko.controller;

import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class WelcomeController {

    @Autowired
    UserDetailsService userDetailsService;


    @GetMapping("/login")
    public String getSigninPage(){
        return "sign-in";
    }

    @GetMapping("/registration")
    public String getSignupPage(){
        return "sign-up";
    }

    @PostMapping("/post-user-info")
    public String sendUserRegistration(@RequestParam String login, @RequestParam String firstName,
                                       @RequestParam String lastName, @RequestParam String email,
                                       @RequestParam String confirmationPassword, @RequestParam LocalDate birthDate,
                                       @RequestParam String gender){
        UserDetails user = new UserDetails();
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        user.setCreationDate(LocalDate.now());
        user.setPassword(confirmationPassword);
        user.setSex(gender);
        user.setActive(false);
        userDetailsService.create(user);
        return "redirect:/welcome";
    }
}
