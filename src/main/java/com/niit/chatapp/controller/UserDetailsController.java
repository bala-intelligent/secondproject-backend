package com.niit.chatapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.chatapp.model.UserDetails;
import com.niit.chatapp.service.UserDetailsService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class UserDetailsController {
	 @Autowired
	    UserDetailsService userdetailservice;  //Service which will do all data retrieval/manipulation work
	  
	     
	    //-------------------Retrieve All Users--------------------------------------------------------
	      
	    @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<UserDetails>> listAllUsers() {
	        List<UserDetails> users = userdetailservice.findAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<UserDetails>>(users, HttpStatus.OK);
	    }
	  
	  
	     
	    //-------------------Retrieve Single User--------------------------------------------------------
	      
	    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<UserDetails> getUser(@PathVariable("id") int userId) {
	        System.out.println("Fetching User with id " + userId);
	        UserDetails user = userdetailservice.findById(userId);
	        if (user == null) {
	            System.out.println("User with id " + userId + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	    }
	  
	      
	      
	    //-------------------Create a User--------------------------------------------------------
	      
	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody UserDetails user,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getName());
	  
	        if (userdetailservice.isUserExist(user)) {
	            System.out.println("A User with name " + user.getName() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	  
	        userdetailservice.saveUser(user);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{userId}").buildAndExpand(user.getUserId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	  
	     
	      
	    //------------------- Update a User --------------------------------------------------------
	      
	    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	    public ResponseEntity<UserDetails> updateUser(@PathVariable("userId") int userId, @RequestBody UserDetails user) {
	        System.out.println("Updating User " + userId);
	          
	        UserDetails currentUser = userdetailservice.findById(userId);
	          
	        if (currentUser==null) {
	            System.out.println("User with id " + userId + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	  
	        currentUser.setName(user.getName());
	        currentUser.setAddress(user.getAddress());
	        currentUser.setEmail_id(user.getEmail_id());
	          
	        userdetailservice.updateUser(currentUser);
	        return new ResponseEntity<UserDetails>(currentUser, HttpStatus.OK);
	    }
	  
	     
	     
	    //------------------- Delete a User --------------------------------------------------------
	      
	    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	    public ResponseEntity<UserDetails> deleteUser(@PathVariable("userId") int userId) {
	        System.out.println("Fetching & Deleting User with id " + userId);
	  
	        UserDetails user = userdetailservice.findById(userId);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + userId + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	  
	        userdetailservice.deleteUserById(userId);
	        return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	    }
	  
	      
	     
	    //------------------- Delete All Users --------------------------------------------------------
	      
	    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	    public ResponseEntity<UserDetails> deleteAllUsers(UserDetails userDetails) {
	        System.out.println("Deleting All Users");
	  
	        userdetailservice.deleteAllUsers(userDetails);
	        return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	    }
	  
	
	
}

