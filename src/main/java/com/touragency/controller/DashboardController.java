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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private ToursDao toursDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private OrdersDao ordersDao;

    @RequestMapping("/dashboard/createtour")
    public String addTour(@Valid Tour tour, BindingResult result) {
        if (result.hasErrors()) {
            return "addTour";
        }
        toursDao.addOrUpdate(tour);
        return "tourAdded";
    }


    @RequestMapping("/dashboard/addtour")
    public String showAddTour(Model model) {
        model.addAttribute("tour", new Tour());
        return "addTour";
    }

    @RequestMapping("/dashboard/userslist")
    public String showUsersList(Model model) {
        List<User> users = usersDao.findAll();
        model.addAttribute("users", users);
        return "usersList";
    }

    @RequestMapping("/dashboard/userblocked")
    public String userBlocked(Model model, @RequestParam(value = "email") String email) {
        User user = usersDao.findByEmail(email);
        model.addAttribute("blockedUser", user);
        usersDao.block(user);
        return "userBlocked";
    }

    @RequestMapping("/dashboard/currentorders")
    public String showCurrentOrders(Model model) {
        List<Order> orders = ordersDao.findAll();
        List<Info> orderInfo = new ArrayList<Info>();

        for (Order order : orders) {
            Tour tour = toursDao.findByTourId(order.getIdTour());
            User user = usersDao.findByEmail(order.getEmail());
            orderInfo.add(new Info(
                    order.getIdOrder(),
                    user.getUsername(),
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

        model.addAttribute("currentOrders", orderInfo);
        return "currentOrders";
    }

    @RequestMapping("/dashboard/currentorders/confirmed")
    public String confirmOrder(@RequestParam(value = "idOrder") int idOrder) {
        ordersDao.confirm(ordersDao.findById(idOrder));
        return "orderConfirmed";
    }
}
