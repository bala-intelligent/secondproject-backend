package com.niit.chatapp.service;

import java.util.List;

import com.niit.chatapp.model.UserDetails;

public interface UserDetailsService {

	
	     
	    UserDetails findById(int userId);
	     
	    UserDetails findByName(String name);
	     
	    void saveUser(UserDetails userDetails);
	     
	    void updateUser(UserDetails userDetails);
	     
	    void deleteUserById(int userId);
	 
	    List<UserDetails> findAllUsers(); 
	     
	    void deleteAllUsers(UserDetails userDetails);
	     
	    public boolean isUserExist(UserDetails userDetails);
	     
	}



     
   
 
