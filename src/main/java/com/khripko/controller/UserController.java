package com.khripko.controller;

import com.khripko.model.Note;
import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/users")
    public ModelAndView getIndex(){
        UserDetails user = new UserDetails();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setLogin("SomeLogin");
        user.setSex("male");
        user.setEmail("some@email.com");
        user.setBirthDate(new Date());
        user.setCreationDate(new Date());
        user.setPassword("somePassword");
        user.setActive(true);

        Note note1 = new Note();
        note1.setUser(user);
        note1.setCreationDate(new Date());
        note1.setTitle("SomeTitle1");
        note1.setText("SomeText1");

        Note note2 = new Note();
        note2.setUser(user);
        note2.setCreationDate(new Date());
        note2.setTitle("SomeTitle2");
        note2.setText("SomeText2");

        user.getNotes().add(note1);
        user.getNotes().add(note2);

        userDetailsService.create(user);

        ModelAndView modelAndView = new ModelAndView("users");
        List<UserDetails> users = userDetailsService.readAll();
        modelAndView.addObject(users);
        return modelAndView;
    }
}
