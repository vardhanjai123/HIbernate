package com.jaivardhan.hibernate;

import com.jaivardhan.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails=new UserDetails();
        userDetails.setUserId(2);
        userDetails.setUserName("Jaivardhan");
        userDetails.setAddress("Address is Gaana Regency Appartment");
        userDetails.setDescription("He is a jolly boy");
        userDetails.setJoinedDate(new Date());
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();

    }

}
