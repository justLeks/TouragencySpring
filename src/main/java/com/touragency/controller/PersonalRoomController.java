package com.touragency.controller;

import com.touragency.dao.OrdersDao;
import com.touragency.dao.ToursDao;
import com.touragency.model.Info;
import com.touragency.model.Order;
import com.touragency.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonalRoomController {

    @Autowired
    private ToursDao toursDao;

    @Autowired
    private OrdersDao ordersDao;

    @RequestMapping("/personalroom/orderedtours")
    public String showDashboard(Principal principal, Model model) {
        String email = principal.getName();
        List<Order> orders = ordersDao.findByEmail(email);
        List<Info> orderInfo = new ArrayList<Info>();

        for (Order order : orders) {
            Tour tour = toursDao.findByTourId(order.getIdTour());
            orderInfo.add(new Info(
                    order.getIdOrder(),
                    email,
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

    @RequestMapping("/personalroom/orderedtours/paid")
    public String payOrder(@RequestParam(value = "idOrder") int idOrder) {
        Order order = ordersDao.findById(idOrder);
        ordersDao.pay(order);
        return "orderPaid";
    }
}
