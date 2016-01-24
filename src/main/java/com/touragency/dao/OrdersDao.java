package com.touragency.dao;

import com.touragency.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class OrdersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Order order) {
        currentSession().saveOrUpdate(order);
    }

    @SuppressWarnings("unchecked")
    public List<Order> findAll() {
        return currentSession().createQuery("from Order").list();
    }

    @SuppressWarnings("unchecked")
    public List<Order> findByEmail(String email) {
        Criteria criteria = currentSession().createCriteria(Order.class);
        criteria.add(Restrictions.eq("email", email));
        return criteria.list();
    }

    public Order findById(int idTour) {
        Criteria criteria = currentSession().createCriteria(Order.class);
        criteria.add(Restrictions.idEq(idTour));
        return (Order) criteria.uniqueResult();
    }

    public void confirm(Order order) {
        order.setConfirmed(true);
        currentSession().saveOrUpdate(order);
    }

    public void pay(Order order) {
        order.setPaid(true);
        currentSession().saveOrUpdate(order);
    }
}
