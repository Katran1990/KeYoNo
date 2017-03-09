package com.khripko.controller;

import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class WelcomeController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/welcome")
    public String getWelcomePage(){
        return "welcome_page";
    }

    @GetMapping("/login")
    public String getSignInPage(){
        return "sign-in";
    }

    @GetMapping("/registration")
    public String getSignUpPage(@ModelAttribute(value = "user") UserDetails user){
        return "sign-up";
    }

    @PostMapping("/post-user-info")
    public String sendUserRegistration(@ModelAttribute(value = "user") UserDetails user, BindingResult result){
        user.setActive(false);
        user.setCreationDate(LocalDate.now());
        userDetailsService.create(user);
        return "redirect:/welcome";
    }

    @PostMapping("/check-user-sign-in")
    public String checkUserSignIn(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request){
        Long userId = userDetailsService.getUserIdIfExist(login);
        if (userId==-1){
            return "redirect:/login";
        }
        UserDetails user = userDetailsService.read(userId);
        if (!user.getPassword().equals(password)){
            return "redirect:/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("currentUserId", user.getId());
        return "redirect:/welcome";
    }
}
