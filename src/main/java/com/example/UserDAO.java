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

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      Users user = new Users(firstName, lastName);
      session.persist(user);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  // gets all users
  public List<Users> getUsers() {
    Session session = sessionFactory.openSession();
    // Java Persistance Query Language
    // works with entities and their attributes
    return session.createQuery("SELECT u FROM Users u", Users.class).getResultList();
  }

  public String getUserById(int id) {

    try (Session session = sessionFactory.openSession()) {
      Users user = session.find(Users.class, id);

      if (user != null) {
        return user.getFirstName() + user.getLastName();
      } else {
        return "user not found";
      }
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
  }
  // updates user's first name
  public void updateUser(int userId, String firstName) {

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      Users user = session.find(Users.class, userId);

      if (user != null) {
        user.setFirstName(firstName);
        session.getTransaction().commit();
        System.out.println("update success");
      } else {
        System.out.println("user id not found");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  // deletes user from db
  public void delete(int userId) {

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      Users user = session.find(Users.class, userId);
      
      if (user != null) {
        session.remove(user);
        session.getTransaction().commit();;
        System.out.println("User deleted");
      } else {
        System.out.println("User not found");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
