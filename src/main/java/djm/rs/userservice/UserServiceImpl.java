/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package djm.rs.userservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author vebrpaa
 */
public class UserServiceImpl implements UserServiceApi{

    @Override
    public void listAllUsers(String fileToParse ) {
        //Input file which needs to be parsed
        BufferedReader fileReader = null;
         
        //Delimiter used in CSV file
        final String DELIMITER = ",";
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
             
            //Read the file line by line
            while ((line = fileReader.readLine()) != null) 
            {
                //Get all users available in line
                String[] employees = line.split(DELIMITER);
                for(String employee : employees )
                {
                    //Print all users
                    System.out.println(employee);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    }

    @Override
    public void createNewUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
