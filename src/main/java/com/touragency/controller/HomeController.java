package com.touragency.controller;

import com.touragency.dao.OrdersDao;
import com.touragency.dao.ToursDao;
import com.touragency.dao.UsersDao;
import com.touragency.model.Info;
import com.touragency.model.Order;
import com.touragency.model.Tour;
import com.touragency.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ToursDao toursDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private OrdersDao ordersDao;

    @RequestMapping("/")
    public String showHomepage() {
        return "home";
    }

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

    @RequestMapping("/dashboard/addtour")
    public String showAddTour(Model model) {
        model.addAttribute("tour", new Tour());
        return "addTour";
    }

    @RequestMapping("/dashboard")
    public String showDashboard(Model model, Principal principal) {
        String email = principal.getName();
        User user = usersDao.findByEmail(email);
        model.addAttribute("user", user);
        return "dashboard";
    }

    @RequestMapping("/personalroom")
    public String showDashboard(Principal principal, Model model) {
        String email = principal.getName();
        List<Order> orders = ordersDao.findByEmail(email);
        List<Info> orderInfo = new ArrayList<Info>();

        for (Order order : orders) {
            Tour tour = toursDao.findByTourId(order.getIdTour());
            orderInfo.add(new Info(
                    order.getFinalPrice(),
                    order.isConfirmed(),
                    order.isPaid(),
                    order.getDate(),
                    tour.getDestCountry(),
                    tour.getStartDay(),
                    tour.getEndDay(),
                    tour.isHot(),
                    tour.getHotelClass(),
                    tour.getFood(),
                    tour.getTourType()
            ));
        }

        model.addAttribute("orderInfo", orderInfo);

        return "personalRoom";
    }
}
