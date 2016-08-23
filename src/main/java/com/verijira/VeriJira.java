package com.verijira;

import com.verijira.domain.User;
import com.verijira.userservice.UserServiceApi;
import com.verijira.userservice.UserServiceImpl;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author djm
 */
public class VeriJira {

    public static final String FILE_PATH = "H:\\veriJiraProject\\employes.csv";
    public static UserServiceApi userService = new UserServiceImpl();

    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter option");
            int option = scan.nextInt();
            if (option == 1) {
                System.out.println("here is list of the users:");


                List<User> users = userService.listAllUsers();

                for (User user : users) {
                    System.out.println(user.getName());
                }

            } else if (option == 2) {
                System.out.println("Please enter new user");
                System.out.println("Enter your Name");
                String name = scan.next();


                System.out.println("Enter your lastname");
                String lastname = scan.next();


                System.out.println("Enter your role");
                String role = scan.next();

                User newUser = new User();
                newUser.setName(name);
                newUser.setLastName(lastname);
                newUser.setRole(role);

                userService.createNewUser(newUser);
 
            } else if (option == 0) {
                break;
            }

        }





    }
}
