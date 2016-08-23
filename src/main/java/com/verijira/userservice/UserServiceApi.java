package com.verijira.userservice;

import com.verijira.domain.User;
import java.util.List;

/**
 *
 * @author vebrpaa
 */
public interface UserServiceApi {

    public List<User> listAllUsers();

    public void createNewUser(User newUser);

    public int getLastUserID();
}
