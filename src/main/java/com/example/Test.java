package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
  public static void main(String[] args) {
    // create configuration
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    configuration.addAnnotatedClass(Users.class);
    
    // create session factory
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
      
      // initialise session object
      Session session = sessionFactory.openSession();

      Users user5 = new Users();
      user5.setFirstName("Eva");
      user5.setLastName("Smith");

      Users user6 = new Users();
      user6.setFirstName("Etta");
      user6.setLastName("Fernandez");
      session.beginTransaction();
      
      session.persist(user5);
      session.persist(user6);
            
      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
