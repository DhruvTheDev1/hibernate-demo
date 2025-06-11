package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s {
  private UserDAO userDAO;

  public s() {
    userDAO = new UserDAO();
  }

  public static void main(String[] args) {
    s app = new s();
    Scanner scanner = new Scanner(System.in);
    // basic example CRUD

    while (true) {
      System.out.println("Welcome!");
      System.out.println("1 - Create User");
      System.out.println("2 - List All Users");
      System.out.println("3 - Get user by id");
      System.out.println("4 - Get User by First Name");
      System.out.println("5 - Update user's first name");
      System.out.println("6 - Delete user by id");
      System.out.println("7 - Exit");

      int input = scanner.nextInt();
      scanner.nextLine();

      if (input == 7) {
        System.out.println("Exiting...");
        break;
      } else if (input == 1) {
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        app.createUser(firstName, lastName);
        System.out.println("User Created");
      } else if (input == 2) {
        List<Users> users = app.listUsers();
        if (users.isEmpty()) {
          System.out.println("No users");
        } else {
          for (Users user : users) {
            System.out.println(user);
          }
        }
      }
    }

    // create user
    // userDAO.createUser("Mariano", "Calderon");

    // get all users
    // List<Users> list = userDAO.getUsers();
    // for (Users user : list) {
    // System.out.println(user);
    // }

    // get user by id
    // System.out.println(userDAO.getUserById(1));

    // get user by name
    // System.out.println(userDAO.getUserByName("Tom"));

    // update user - currently only updates first name
    // currently - kept it so you need to inser user ID and first name
    // userDAO.updateUser(1, "Tom");

    // delete a user based on id
    // userDAO.delete(7);
  }

  public void createUser(String firstName, String lastName) {
    userDAO.createUser(firstName, lastName);
  }

  public List<Users> listUsers() {
    List<Users> users = userDAO.getUsers();
    return users;
  }
}
