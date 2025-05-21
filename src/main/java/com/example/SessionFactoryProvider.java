package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
  public static SessionFactory providSessionFactory() {
    Configuration config = new Configuration();
    // Configures Hibernate with hibernate.cfg.xml
    config.configure();
    config.addAnnotatedClass(Users.class);
    return config.buildSessionFactory();
  }
}
