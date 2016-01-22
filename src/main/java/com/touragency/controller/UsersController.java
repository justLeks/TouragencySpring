package com.touragency.controller;

import com.touragency.dao.UsersDao;
import com.touragency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String createUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "signUp";
        }
        user.setEnabled(true);
        user.setAuthority("ROLE_USER");
        usersDao.add(user);
        return "userCreated";
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
