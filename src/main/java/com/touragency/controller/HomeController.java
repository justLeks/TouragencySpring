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
