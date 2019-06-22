package com.example.memeBlog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;

@Controller
@RequestMapping("home")
public class userController {


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String userHome(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "User/userHome";
    }

    @RequestMapping(value="/add/{username}", method = RequestMethod.GET)
    public String addMeme(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "User/addMeme";
    }

    @RequestMapping(value="/friends/{username}", method = RequestMethod.GET)
    public String friends(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "User/friends";
        }



}
