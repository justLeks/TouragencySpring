package com.touragency.controller;

import com.touragency.dao.OrdersDao;
import com.touragency.dao.ToursDao;
import com.touragency.model.Order;
import com.touragency.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class ToursController {

    @Autowired
    private ToursDao toursDao;

    @Autowired
    private OrdersDao ordersDao;

    @RequestMapping("/tours/allavaliabletours")
    public String showAllTours(Model model) {
        List<Tour> tours = toursDao.findAll();
        model.addAttribute("tours", tours);
        return "allAvailableTours";
    }

    @RequestMapping("/tours/shoppingtours")
    public String showShoppingTours(Model model) {
        List<Tour> tours = toursDao.findByTourType("Shopping");
        model.addAttribute("shoppingTours", tours);
        return "shoppingTours";
    }

    @RequestMapping("/tours/excursiontours")
    public String showExcursionTours(Model model) {
        List<Tour> tours = toursDao.findByTourType("Excursion");
        model.addAttribute("excursionTours", tours);
        return "excursionTours";
    }

    @RequestMapping("/tours/vacationtours")
    public String showVacationTours(Model model) {
        List<Tour> tours = toursDao.findByTourType("Vacation");
        model.addAttribute("vacationTours", tours);
        return "vacationTours";
    }

    @RequestMapping("/tours/buytour")
    public String orderTour(Principal principal,
                            @RequestParam(value = "idTour") int idTour,
                            @RequestParam(value = "price") int price) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Order order = new Order();
        order.setIdTour(idTour);
        order.setEmail(principal.getName());
        order.setFinalPrice(price);
        order.setDate(dateFormat.format(Calendar.getInstance().getTime()));
        order.setConfirmed(false);
        order.setPaid(false);

        ordersDao.add(order);

        return "tourOrdered";
    }
}
