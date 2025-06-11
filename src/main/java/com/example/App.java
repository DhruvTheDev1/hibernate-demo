package com.example;

import java.util.List;
import java.util.Scanner;

public class App {
  private UserDAO userDAO;

  public App() {
    userDAO = new UserDAO();
  }

  public static void main(String[] args) {
    App app = new App();
    Scanner scanner = new Scanner(System.in);

    // basic console CRUD
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
      // exit application
      if (input == 7) {
        System.out.println("Exiting...");
        break;

        // create user
      } else if (input == 1) {
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        app.createUser(firstName, lastName);
        System.out.println("User Created");

        // list all users
      } else if (input == 2) {
        List<Users> users = app.listUsers();
        for (Users user : users) {
          System.out.println(user);
        }
      }

      // get user by id
      else if (input == 3) {
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(app.getUserByID(id));
      }

      // get user by first name
      else if (input == 4) {
        System.out.println("Enter User's first name");
        String fname = scanner.nextLine();
        System.out.println(app.getUserByFirstName(fname));
      }

      // update user's first name
      // currently kept it so id and first name needed
      else if (input == 5) {
        System.out.println("Enter user ID");
        int userid = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter user first name");
        String first = scanner.nextLine();
        app.updateUser(userid, first);
      }

      // delete user by id
      else if (input == 6) {
        System.out.println("Enter user id to delete");
        int id = scanner.nextInt();
        scanner.nextLine();
        app.deleteUserById(id);
      } else {
        System.out.println("Invalid input");
      }
    } // end of while
  }

  public void createUser(String firstName, String lastName) {
    userDAO.createUser(firstName, lastName);
  }

  public List<Users> listUsers() {
    List<Users> users = userDAO.getUsers();
    return users;
  }

  public String getUserByID(int id) {
    return userDAO.getUserById(id);
  }

  public String getUserByFirstName(String fName) {
    return userDAO.getUserByName(fName);
  }

  public void updateUser(int id, String fName) {
    userDAO.updateUser(id, fName);
  }

  public void deleteUserById(int id) {
    userDAO.delete(id);
  }

}
