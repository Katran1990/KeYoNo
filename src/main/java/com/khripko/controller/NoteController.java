package com.khripko.controller;

import com.khripko.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping("/notes")
    public String getNotesPage(Model model, HttpServletRequest request){
        model.addAttribute("notes", noteService.readAll());
        return "notes";
    }
}
