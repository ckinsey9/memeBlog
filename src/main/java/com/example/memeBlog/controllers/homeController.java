package com.example.memeBlog.controllers;


import com.example.memeBlog.models.User;
import com.example.memeBlog.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "")
public class homeController {



    @Autowired
    private UserDao userDao;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private Cookie userCookie;

    @Autowired
    private HttpServletResponse response;


    @RequestMapping(value= "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "MemeBlog | Homepage");
        return "Home/index";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "MemeBlog | Login");
        model.addAttribute(new User());
        return "Login/login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute @Valid User returningUser, Errors errors,
                               Model model) {
        if (errors.hasErrors()) {
            model.addAttribute(returningUser);
            model.addAttribute("title", "MemeBlog | Login");

            return "Login/login";
        }

        String username = returningUser.getUsername();
        String password = returningUser.getPassword();

        if (userDao.findByUsername(username) != null &&
                encoder.matches(password, userDao.findByUsername(username).getPassword())) {

            userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60 * 2);
            userCookie.setPath("/");
            response.addCookie(userCookie);
            return "redirect:/home/" + username;
        }

        model.addAttribute(returningUser);
        model.addAttribute("title", "MemeBlog | Login");
        model.addAttribute("usernameError", "Username Error: Please try again or register an account.");

        return "Login/login";
    }

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("title", "MemeBlog | Register");
        model.addAttribute(new User());
        return "Login/register";
    }

    @RequestMapping(value="register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute @Valid User newUser, Errors errors,
                                  Model model, @RequestParam String verify) throws Exception{
        if (errors.hasErrors()) {
            model.addAttribute("title", "MemeBlog | Register");
            model.addAttribute(newUser);
            return "Login/register";
        }

        String username = newUser.getUsername();
        String password = newUser.getPassword();

        if (!password.equals(verify)) {
            model.addAttribute("title", "MemeBlog | Register");
            model.addAttribute(newUser);
            model.addAttribute("passwordError", "Passwords do not match");
            return "Login/register";
        }

        if (userDao.findByUsername(username) != null) {
            model.addAttribute("title", "MemeBlog | Register");
            model.addAttribute(newUser);
            model.addAttribute("passwordError", "Username is already taken");
            return "Login/register";
        }

        String safePass = encoder.encode(newUser.getPassword());
        newUser.setPassword(safePass);
        userDao.save(newUser);

        userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60 * 60 * 2);
        userCookie.setPath("/");
        response.addCookie(userCookie);
        return "redirect:/home/" + username;

    }

    @RequestMapping(value = "logoutProcessor")
    public String logoutProcessor() {
        userCookie = new Cookie("username", "");
        userCookie.setMaxAge(0);
        userCookie.setPath("/");
        response.addCookie(userCookie);
        return "redirect:";
    }
}
