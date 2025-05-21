package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {
  private SessionFactory sessionFactory;

  public UserDAO() {
    this.sessionFactory = SessionFactoryProvider.providSessionFactory();
  }

  // create a user
  public void createUser(String firstName, String lastName) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Users user = new Users(firstName, lastName);
    session.persist(user);
    session.getTransaction().commit();
    session.close();
  }
  // gets all users
  public List<Users> getUsers() {
    Session session = sessionFactory.openSession();
    // Java Persistance Query Language
    // works with entities and their attributes
    return session.createQuery("SELECT u FROM Users u", Users.class).getResultList();
  }
  // updates user's first name
  public void updateUser(int userId, String firstName) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Users user = session.find(Users.class, userId);

    if (user != null) {
      user.setFirstName(firstName);
      session.getTransaction().commit();
      System.out.println("Update Success");
    } else {
      System.out.println("User ID not found");
    }
    session.close();
  }
  // deletes user from db
  public void delete(int userId) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Users user = session.find(Users.class, userId);

    if (user != null) {
    session.remove(user);
    session.getTransaction().commit();
    System.out.println("User deleted");  
    } else {
      System.out.println("User not found");
    }
    session.close();
  }
}
