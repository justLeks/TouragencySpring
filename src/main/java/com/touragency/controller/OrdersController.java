package com.touragency.controller;

import com.touragency.dao.OrdersDao;
import com.touragency.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class OrdersController {

    @Autowired
    private OrdersDao ordersDao;

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
