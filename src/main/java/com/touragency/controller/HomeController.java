package com.touragency.controller;

import com.touragency.dao.ToursDao;
import com.touragency.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ToursDao toursDao;

    @RequestMapping("/")
    public String showHomepage() {
        return "home";
    }

    @RequestMapping("/allavaliabletours")
    public String showAllTours(Model model) {
        List<Tour> tours = toursDao.findAll();
        model.addAttribute("tours", tours);
        return "allAvailableTours";
    }

    @RequestMapping("/shoppingtours")
    public String showShoppingTours(Model model) {
        List<Tour> tours = toursDao.findByTourType("Shopping");
        model.addAttribute("shoppingTours", tours);
        return "shoppingTours";
    }

    @RequestMapping("/excursiontours")
    public String showExcursionTours(Model model) {
        List<Tour> tours = toursDao.findByTourType("Excursion");
        model.addAttribute("excursionTours", tours);
        return "excursionTours";
    }

    @RequestMapping("/vacationtours")
    public String showVacationTours(Model model) {
        List<Tour> tours = toursDao.findByTourType("Vacation");
        model.addAttribute("vacationTours", tours);
        return "vacationTours";
    }

    @RequestMapping("/addtour")
    public String showAddTour(Model model) {
        model.addAttribute("tour", new Tour());
        return "addTour";
    }

    @RequestMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
}
