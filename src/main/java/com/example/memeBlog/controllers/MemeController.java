package com.example.memeBlog.controllers;

import com.example.memeBlog.models.Meme;
import com.example.memeBlog.models.data.MemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "meme")
public class MemeController {

    @Autowired
    private MemeDao memeDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addDisplay(Model model, @ModelAttribute Meme meme) {
        model.addAttribute("title", "Meme - add");
        return "Meme/addMeme";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addProcess(Model model, @ModelAttribute @Valid Meme meme, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Meme - add");
            return "Meme/addMeme";
        }
        memeDao.save(meme);
        return "HOLDER";
    }

}
