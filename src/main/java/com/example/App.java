package com.example;

import java.util.List;

public class App {
  public static void main(String[] args) {
    UserDAO userDAO = new UserDAO();
    // basic example CRUD
    System.out.println("Welcome!");
    System.out.println("1 - Create User");
    System.out.println("2 - List All Users");
    System.out.println("3 - Get user by id");
    System.out.println("4 - Get User by First Name");
    System.out.println("5 - Update user's first name"); 
    System.out.println("6 - Delete user by id");
    
    // create user
    // userDAO.createUser("Mariano", "Calderon");

    // get all users
    // List<Users> list = userDAO.getUsers();
    // for (Users user : list) {
    //   System.out.println(user);
    // }

    // get user by id
   // System.out.println(userDAO.getUserById(1));

   // get user by name
   System.out.println(userDAO.getUserByName("Tom"));

    // update user - currently only updates first name
    // currently - kept it so you need to inser user ID and first name
    // userDAO.updateUser(1, "Tom");

    // delete a user based on id
    // userDAO.delete(7);
  }
}
