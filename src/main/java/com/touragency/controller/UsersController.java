package com.touragency.controller;

import com.touragency.dao.UsersDao;
import com.touragency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping("/signup")
    public String showSignUp(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }

    @RequestMapping("/createuser")
    public String createUser(@Valid User user, BindingResult result, Model model, @RequestParam(value = "email") String email) {
        if (result.hasErrors()) {
            return "signUp";
        }

        if (usersDao.findByEmail(email) != null) {
            model.addAttribute("userExists", "User with this email already exists");
            return "signUp";
        }

        user.setEnabled(true);
        user.setAuthority("ROLE_USER");
        usersDao.add(user);
        model.addAttribute("newUser", user);
        return "login";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/loggedout")
    public String showLoggedOut() {
        return "loggedout";
    }

}
