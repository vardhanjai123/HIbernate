package com.jaivardhan.hibernate;

import com.jaivardhan.dto.Address;
import com.jaivardhan.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails=new UserDetails();
        UserDetails userDetails2=new UserDetails();
        Address address=new Address();
        address.setState("bihar");
        address.setCity("Patna");
        address.setPincode("560078");
        address.setStreet("RKPURAM");
        userDetails.setUserName("Jaivardhan");
        userDetails2.setUserName("AnandVardhan");
        userDetails.setAddress(address);
        userDetails2.setAddress(address);
        userDetails.setDescription("He is a jolly boy");
        userDetails2.setDescription("He is a jolly boy");
        userDetails.setJoinedDate(new Date());
        userDetails2.setJoinedDate(new Date());
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(userDetails2);
        session.getTransaction().commit();
        session.close();
        userDetails=null;
        session=sessionFactory.openSession();
        session.beginTransaction();
        userDetails= (UserDetails) session.get(UserDetails.class,2);
        System.out.println(userDetails.getUserName());

    }

}
