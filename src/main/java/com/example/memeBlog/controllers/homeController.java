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
        model.addAttribute("title", "memeBlog | Homepage");
        return "Home/index";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "memeBlog | Login");
        return "Login/login";
    }

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("title", "memeBlog | Register");
        return "Login/register";
    }
}
