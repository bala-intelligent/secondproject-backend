package com.niit.chatapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.chatapp.model.Forum;
import com.niit.chatapp.service.ForumService;

@RestController
public class FormController {

	
	@Autowired
	private ForumService forumservice;
	
	  
    
   
  
  
     
    //-------------------Retrieve Single user's forum--------------------------------------------------------
      
    @RequestMapping(value = "/forum/{forumid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Forum> getForum(@PathVariable("forumid") int forumid) {
        System.out.println("Fetching forum with id " + forumid);
        Forum forum = forumservice.findById(forumid);
        if (forum == null) {
            System.out.println("User with id " + forumid + " not found");
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Forum>(forum, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Forum--------------------------------------------------------
      
    @RequestMapping(value = "/forum/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Forum forum,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating forum " + forum.getForumname());
  
        
  
        forumservice.saveforum(forum);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/forum/{forumid}").buildAndExpand(forum.getForumid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Forum --------------------------------------------------------
      
    @RequestMapping(value = "/forum/{forumid}", method = RequestMethod.PUT)
    public ResponseEntity<Forum> updateForum(@PathVariable("forumid") int forumid, @RequestBody Forum forum) {
        System.out.println("Updating question " + forumid);
          
       Forum currentUserForum  = forumservice.findById(forumid);
          
        if (currentUserForum==null) {
            System.out.println("User with id " + forumid + " not found");
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
  
        currentUserForum.setForumname(forum.getForumname());
        currentUserForum.setForumapproved(forum.getForumapproved());
        currentUserForum.setPostedtime(forum.getPostedtime());
        currentUserForum.setPosteddate(forum.getPosteddate());
          
        forumservice.updateforum(currentUserForum);
        return new ResponseEntity<Forum>(currentUserForum, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Forum --------------------------------------------------------
      
    @RequestMapping(value = "/forum/{forumid}", method = RequestMethod.DELETE)
    public ResponseEntity<Forum> deleteUser(@PathVariable("forumid") int forumid) {
        System.out.println("Fetching & Deleting Forum with id " + forumid);
  
        Forum forum = forumservice.findById(forumid);
        if (forum == null) {
            System.out.println("Unable to delete. Forum with id " + forumid + " not found");
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
  
        forumservice.deleteforumById(forumid);
        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
    }
  
}
