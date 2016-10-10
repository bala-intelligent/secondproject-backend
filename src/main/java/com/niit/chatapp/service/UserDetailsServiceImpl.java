package com.niit.chatapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.chatapp.dao.UserDetailsDao;
import com.niit.chatapp.model.UserDetails;

@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private UserDetailsDao userdao;
	
	@Override
	public UserDetails findById(int userId) {
		
	 return userdao.findById(userId);
	}
	@Override
	public UserDetails findByName(String name) {
		// TODO Auto-generated method stub
		return userdao.findByName(name);
	}

	@Override
	public void saveUser(UserDetails userDetails) {
		userdao.saveUser(userDetails);
		
	}

	@Override
	public void updateUser(UserDetails userDetails) {
		
		userdao.updateUser(userDetails);
	}

	@Override
	public void deleteUserById(int userId) {
		userdao.deleteUserById(userId);
	}

	@Override
	public List<UserDetails> findAllUsers() {
		
		return userdao.findAllUsers();
	}

	@Override
	public void deleteAllUsers(UserDetails userDetails) {
		userdao.deleteAllUsers(userDetails);;
	}

	@Override
	public boolean isUserExist(UserDetails userDetails) {
		
		return userdao.isUserExist(userDetails);
	}
	 
     
	   
	 
	    
}
