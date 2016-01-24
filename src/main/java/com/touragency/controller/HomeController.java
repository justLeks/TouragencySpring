package com.touragency.controller;

import com.touragency.dao.UsersDao;
import com.touragency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping("/")
    public String showHomepage() {
        return "home";
    }

    @RequestMapping("/dashboard")
    public String showDashboard(Model model, Principal principal) {
        String email = principal.getName();
        User user = usersDao.findByEmail(email);
        model.addAttribute("user", user);
        return "dashboard";
    }

    @RequestMapping("/personalroom")
    public String showPersonalRoom() {
        return "personalRoom";
    }

}
