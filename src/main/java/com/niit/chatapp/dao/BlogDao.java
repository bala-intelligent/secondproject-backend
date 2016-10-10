package com.niit.chatapp.dao;

import com.niit.chatapp.model.Blog;

public interface BlogDao {

Blog findById(int blogid);
    
    Blog findByName(String name);
     
    void saveblog(Blog blog);
     
    void updateblog(Blog blog);
     
    void deleteblogById(int blogid);
 
   public boolean isExistBlog(Blog blog);
}
