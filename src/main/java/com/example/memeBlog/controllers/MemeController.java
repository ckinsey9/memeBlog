package com.example.memeBlog.controllers;

import com.example.memeBlog.models.Meme;
import com.example.memeBlog.models.data.MemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping(value = "meme")
public class MemeController {

    @Autowired
    private MemeDao memeDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        return "meme/index";
    }

    @RequestMapping(value = "/{meme_id}")
    public String memeDisplay(Model model, @PathVariable int meme_id) {
        String pic_base64 = new String(Base64.getEncoder().encode(memeDao.findById(meme_id).get().getPic()));
        model.addAttribute("title", "title");
        model.addAttribute("pic", pic_base64);
        model.addAttribute(memeDao.findById(meme_id).get());
        return "meme/display";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addDisplay(Model model, @ModelAttribute Meme meme) {
        model.addAttribute("title", "Meme - add");
        return "Meme/addMeme";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addProcess(Model model, @RequestParam("file") MultipartFile file, @ModelAttribute @Valid Meme meme, Errors errors) throws IOException {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Meme - add");
            return "Meme/addMeme";
        }
        byte[] pic = file.getBytes();
        meme.setPic(pic);
        memeDao.save(meme);
        return "redirect:" + meme.getId();
    }
}
