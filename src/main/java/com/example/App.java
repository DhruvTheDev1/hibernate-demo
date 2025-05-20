package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
  public static void main(String[] args) {
    // create configuration
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    configuration.addAnnotatedClass(Users.class);
    
    // create session factory
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
      
      // initialise session object
      Session session = sessionFactory.openSession();

      // Users user1 = new Users();
      // user1.setFirstName("Tom");
      // user1.setLastName("Smith");

      Users user2 = new Users();
      user2.setFirstName("Tom");
      user2.setLastName("Smith");

      Users user3 = new Users();
      user3.setFirstName("Elaine");
      user3.setLastName("Smith");

      Users user4 = new Users();
      user4.setFirstName("Ava");
      user4.setLastName("Alan");

      session.beginTransaction();
      
      session.persist(user2);
      session.persist(user3);
      session.persist(user4);
      
      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
