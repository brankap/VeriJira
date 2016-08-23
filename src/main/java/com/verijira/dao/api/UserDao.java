package com.verijira.dao.api;

import com.verijira.domain.User;
import java.util.List;

/**
 *
 * @author vebrpaa
 */
public interface UserDao {

    public List<User> listAllUsers();
    
    public void saveUser(User user);
    
    public int getNextUserID();
    
    
}
