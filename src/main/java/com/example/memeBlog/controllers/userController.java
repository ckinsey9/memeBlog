package com.example.memeBlog.controllers;


import com.example.memeBlog.models.data.MemeDao;
import com.example.memeBlog.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("home")
public class userController {

    @Autowired
    private MemeDao memeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String userHome(@PathVariable String username, Model model) {

        if (WebUtils.getCookie(request, "username") == null) {
            return "redirect:/logoutProcessor";
        }

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                if (!cookie.getValue().equals(username)) {
                    return "redirect:/logoutProcessor";
                }
            }
        }
        model.addAttribute("title", "'MemeBlog | ' + username");
        model.addAttribute("username", username);
        return "User/userHome";
    }

    @RequestMapping(value="/add/{username}", method = RequestMethod.GET)
    public String addMeme(@PathVariable String username, Model model) {

        if (WebUtils.getCookie(request, "username") == null) {
            return "redirect:/logoutProcessor";
        }

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                if (!cookie.getValue().equals(username)) {
                    return "redirect:/logoutProcessor";
                }
            }
        }

        model.addAttribute("title", "username + ' | Add Meme'");

        model.addAttribute("username", username);
        return "Meme/addMeme";
    }

    @RequestMapping(value="/friends/{username}", method = RequestMethod.GET)
    public String friends(@PathVariable String username, Model model) {

        if (WebUtils.getCookie(request, "username") == null) {
            return "redirect:/logoutProcessor";
        }

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                if (!cookie.getValue().equals(username)) {
                    return "redirect:/logoutProcessor";
                }
            }
        }

        model.addAttribute("title", "username + ' | Following'");

        model.addAttribute("username", username);
        return "User/friends";
        }



}
