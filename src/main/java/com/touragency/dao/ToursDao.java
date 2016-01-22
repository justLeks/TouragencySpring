package com.touragency.dao;

import com.touragency.model.Tour;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ToursDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Tour> findAll() {
        return currentSession().createQuery("from Tour").list();
    }

    public void addOrUpdate(Tour tour) {
        currentSession().saveOrUpdate(tour);
    }

    @SuppressWarnings("unchecked")
    public List<Tour> findByTourType(String tourType) {
        Criteria criteria = currentSession().createCriteria(Tour.class);
        criteria.add(Restrictions.eq("tourType", tourType));
        return criteria.list();
    }

    public Tour findByTourId(int idTour) {
        Criteria criteria = currentSession().createCriteria(Tour.class);
        criteria.add(Restrictions.eq("idTour", idTour));
        return (Tour) criteria.uniqueResult();
    }
}
