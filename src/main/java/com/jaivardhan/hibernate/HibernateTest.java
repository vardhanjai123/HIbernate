package com.jaivardhan.hibernate;

import com.jaivardhan.dto.Address;
import com.jaivardhan.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {

        Address address1=new Address();
        address1.setState("Bihar");
        address1.setCity("Patna");
        address1.setPincode("800001");
        address1.setStreet("Ganga Vihar Colony");

        Address address2=new Address();
        address2.setState("Karnataka");
        address2.setCity("Bangalore");
        address2.setPincode("560078");
        address2.setStreet("Naidu Layout");

        UserDetails userDetails=new UserDetails();

        userDetails.setUserName("jaivardhan");
        userDetails.setJoinedDate(new Date());
        userDetails.setDescription("Hello All I am a very jolly boy!!");
        userDetails.getListOfAddresses().add(address1);
        userDetails.getListOfAddresses().add(address2);





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
