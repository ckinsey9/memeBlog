package com.example.memeBlog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class homeController {


    @RequestMapping(value= "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Homepage | memeBlog");
        return "Home/index";
    }
}
