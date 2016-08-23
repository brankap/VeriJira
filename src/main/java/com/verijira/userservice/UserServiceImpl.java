package com.verijira.userservice;

import com.verijira.dao.api.UserDao;
import com.verijira.dao.impl.csv.UserDaoCSV;
import com.verijira.domain.User;
import java.util.List;

/**
 *
 * @author vebrpaa
 */
public class UserServiceImpl implements UserServiceApi {

    private UserDao userDao = new UserDaoCSV();

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    public void createNewUser(User newUser) {
        userDao.saveUser(newUser);
    }

    public int getLastUserID() {
        int lastUserID = listAllUsers().size() - 1;
        return lastUserID;
    }
}
