package com.verijira.dao.impl.csv;

import com.verijira.dao.api.UserDao;
import com.verijira.domain.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vebrpaa
 */
public class UserDaoCSV implements UserDao {

    private static final String FILE_TO_PARSE = "H:\\veriJiraProject\\employes.csv";

    @Override
    public List<User> listAllUsers() {
        //Input file which needs to be parsed
        BufferedReader fileReader = null;

        //Delimiter used in CSV file
        final String DELIMITER = ",";
        List<User> users = new ArrayList<User>();
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(FILE_TO_PARSE));
            //first line has names of columns
            fileReader.readLine();

            //Read the file line by line
            while ((line = fileReader.readLine()) != null) {
                //Get all users available in line  
                String[] userData = line.split(DELIMITER);
                User user = new User();
                user.setId(Integer.parseInt(userData[0]));
                user.setName(userData[1]);
                user.setLastName(userData[2]);
                user.setRole(userData[3]);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return users;

    }

    @Override
    public void saveUser(User user) {
        try {
            File file = new File(FILE_TO_PARSE);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            int newUserId = getNextUserID();
            String newUser = Integer.toString(newUserId)+ "," + user.getName()+ "," + user.getLastName() + "," + user.getRole();
            fw.append("\n");
            fw.append(newUser);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getNextUserID() {
        int lastUserID = listAllUsers().get(listAllUsers().size()-1).getId();
        int nextUserId = lastUserID + 1;
        return nextUserId;
    }
}
