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

import com.niit.chatapp.model.Blog;

import com.niit.chatapp.service.BlogService;

@RestController
public class BlogController {

	@Autowired
	 BlogService blogservice;
	
	  
    
   
  
  
     
    //-------------------Retrieve Single Blog--------------------------------------------------------
      
    @RequestMapping(value = "/blog/{blogid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("blogid") int blogid) {
        System.out.println("Fetching blog with id " + blogid);
        Blog blog = blogservice.findById(blogid);
        if (blog == null) {
            System.out.println("Blog with id " + blogid + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a Blog--------------------------------------------------------
      
    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating blog " + blog.getBlogname());
  
        
  
        blogservice.saveblog(blog);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blog/{blogid}").buildAndExpand(blog.getBlogid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a Blog --------------------------------------------------------
      
    @RequestMapping(value = "/blog/{blogid}", method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateBlog(@PathVariable("blogid") int blogid, @RequestBody Blog blog) {
        System.out.println("Updating Blog " + blogid);
          
        Blog currentUserblog = blogservice.findById(blogid);
          
        if (currentUserblog==null) {
            System.out.println("Blog with id " + blogid + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
  
        currentUserblog.setBlogname(blog.getBlogname());
        currentUserblog.setImagename(blog.getImagename());
        currentUserblog.setApproved(blog.getApproved());
        currentUserblog.setPostTime(blog.getPostTime());
        currentUserblog.setPostDate(blog.getPostDate());
          
        blogservice.updateblog(currentUserblog);
        return new ResponseEntity<Blog>(currentUserblog, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a Blog --------------------------------------------------------
      
    @RequestMapping(value = "/blog/{blogid}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog(@PathVariable("blogid") int blogid) {
        System.out.println("Fetching & Deleting Blog with id " + blogid);
  
        Blog blog = blogservice.findById(blogid);
        if (blog == null) {
            System.out.println("Unable to delete. Blog with id " + blogid + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
  
        blogservice.deleteblogById(blogid);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
  
      
     
    
  
}
