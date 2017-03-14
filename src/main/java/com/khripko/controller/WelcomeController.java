package com.khripko.controller;

import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    public String getSignInPage(Model model){
        if (model.asMap().size()!=0) {
            Model newModel = (Boolean) model.asMap().get("is-correct") ? model.addAttribute("correct", true) : model.addAttribute("correct", false);
        }
        return "sign-in";
    }

    @GetMapping("/registration")
    public String getSignUpPage(@ModelAttribute(value = "user") UserDetails user){
        return "sign-up";
    }

    @PostMapping("/post-user-info")
    public String sendUserRegistration(@ModelAttribute(value = "user") UserDetails user, BindingResult result){
        user.setBirthDate(user.getBirthDate().plusDays(1));
        user.setActive(false);
        user.setCreationDate(LocalDate.now().plusDays(1));
        userDetailsService.create(user);
        return "redirect:/welcome";
    }

    @PostMapping("/check-user-sign-in")
    public String checkUserSignIn(@RequestParam("login") String login, @RequestParam("password") String password, Model model, HttpServletRequest request){
        Long userId = userDetailsService.getUserIdIfExist(login);
        if (userId==-1){
            model.addAttribute("is-correct", false);
            return "/login";
        }
        UserDetails user = userDetailsService.read(userId);
        if (!user.getPassword().equals(password)){
            model.addAttribute("is-correct", false);
            return "/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("currentUserId", user.getId());
        return "redirect:/welcome";
    }
}
