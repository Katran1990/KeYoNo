package com.khripko.controller;

import com.khripko.model.Note;
import com.khripko.model.UserDetails;
import com.khripko.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/users")
    public String getIndex(Model model){
        UserDetails user = new UserDetails();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setLogin("SomeLogin");
        user.setSex("male");
        user.setEmail("some@email.com");
        user.setBirthDate(LocalDate.of(1991, Month.AUGUST, 12));
        user.setCreationDate(LocalDate.now());
        user.setPassword("somePassword");
        user.setActive(true);

        Note note1 = new Note();
        note1.setUser(user);
        note1.setCreationDate(LocalDate.now());
        note1.setTitle("SomeTitle1");
        note1.setText("SomeText1");

        Note note2 = new Note();
        note2.setUser(user);
        note2.setCreationDate(LocalDate.now());
        note2.setTitle("SomeTitle2");
        note2.setText("SomeText2");

        user.getNotes().add(note1);
        user.getNotes().add(note2);

        userDetailsService.create(user);

        List<UserDetails> users = userDetailsService.readAll();
        model.addAttribute(users);
        return "users";
    }
}
