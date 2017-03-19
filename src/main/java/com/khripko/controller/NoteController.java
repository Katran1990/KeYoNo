package com.khripko.controller;

import com.khripko.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping("/notes")
    public String getNotesPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        while (session.getAttributeNames().hasMoreElements()){
            if(session.getAttributeNames().nextElement().equals("currentUserId")){
                model.addAttribute("notes", noteService.readAll());
                return "notes";
            }
        }
        return "redirect:/login";
    }
}
