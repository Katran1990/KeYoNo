package com.khripko.controller;

import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/check-user")
    public String checkUser(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request){
        if (login==null||password==null){
            return "redirect:/login";
        }
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
        return "redirect:/users";
    }


    @GetMapping("/users")
    public String getIndex(Model model, HttpServletRequest request){
        List<UserDetails> users = userDetailsService.readAll();
        model.addAttribute(users);
        return "users";
    }
}
