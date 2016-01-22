package com.touragency.dao;

import com.touragency.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(User user) {
        user.setEncodedPassword(passwordEncoder.encode(user.getPassword()));
        currentSession().saveOrUpdate(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return currentSession().createQuery("from User").list();
    }

    public void block(User user) {
        user.setEnabled(false);
        currentSession().saveOrUpdate(user);
    }

    public User findByEmail(String email) {
        Criteria criteria = currentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }
}
