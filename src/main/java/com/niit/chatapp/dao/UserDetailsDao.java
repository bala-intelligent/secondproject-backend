package com.niit.chatapp.dao;

import java.util.List;

import com.niit.chatapp.model.UserDetails;

public interface UserDetailsDao {

	UserDetails findById(int userId);
    
    UserDetails findByName(String name);
     
    void saveUser(UserDetails userDetails);
     
    void updateUser(UserDetails userDetails);
     
    void deleteUserById(int userId);
 
    List<UserDetails> findAllUsers(); 
     
    public boolean isUserExist(UserDetails userDetails);

	void deleteAllUsers(UserDetails userDetails);
}
