package djm.rs;

import djm.rs.userservice.UserServiceApi;
import djm.rs.userservice.UserServiceImpl;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author djm
 */
public class veriJira {
    
    public static final String FILE_PATH = "H:\\veriJiraProject\\employes.csv";
    public static UserServiceApi userService = new UserServiceImpl();  

    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.

        Scanner test = new Scanner(System.in);
        while(true) {
            System.out.println("Please enter option");
            int option = test.nextInt();
            if (option == 1) {
                System.out.println("here is list of the users:");
                userService.listAllUsers(FILE_PATH);
                
            } else if (option == 2) {
                System.out.println("Please enter new user");
                System.out.println("Enter your Name");
                String name = test.next();
                //System.out.println(name);

                System.out.println("Enter your lastname");
                String lastname = test.next();
               // System.out.println(lastname);

                System.out.println("Enter your role");
                String role = test.next();
  
                
                String newUser = name + "," + lastname + "," + role;
                
                userService.createNewUser(newUser , FILE_PATH);
                userService.listAllUsers(FILE_PATH);

            } else if (option == 0) {
                break;
            }

        }
        
        
        
        

    }
    
   
}
