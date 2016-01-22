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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ToursDao toursDao;

    @Autowired
    private OrdersDao ordersDao;

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

    @RequestMapping("/personalroom/orderedtours")
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

        return "orderedTours";
    }
}
