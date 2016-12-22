package com.khripko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SimpleController {

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }
}
