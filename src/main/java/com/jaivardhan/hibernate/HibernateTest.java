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
        Address address=new Address();
        Address officeAddress=new Address();

        //home address
        address.setState("bihar");
        address.setCity("Patna");
        address.setPincode("800006");
        address.setStreet("Pather ki masjid");

        //office Address
        officeAddress.setStreet("Sachivalay Street");
        officeAddress.setCity("patna");
        officeAddress.setPincode("800009");
        officeAddress.setState("bihar");

        userDetails.setUserName("Jaivardhan");
        userDetails.setAddress(address);
        userDetails.setOfficeAddress(officeAddress);
        userDetails.setDescription("He is a jolly boy");
        userDetails.setJoinedDate(new Date());

        //code to get session factory
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        //code to get session
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();
        userDetails=null;
        session=sessionFactory.openSession();
        session.beginTransaction();
        userDetails= (UserDetails) session.get(UserDetails.class,1);
        System.out.println(userDetails.getUserName());

    }

}
