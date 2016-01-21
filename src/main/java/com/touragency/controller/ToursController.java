package com.touragency.controller;

import com.touragency.dao.ToursDao;
import com.touragency.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ToursController {

    @Autowired
    private ToursDao toursDao;

    @RequestMapping("/dashboard/createtour")
    public String addTour(@Valid Tour tour, BindingResult result) {
        if (result.hasErrors()) {
            return "addTour";
        }
        toursDao.addOrUpdate(tour);
        return "tourAdded";
    }
}
