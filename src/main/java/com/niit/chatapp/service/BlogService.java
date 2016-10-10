package com.niit.chatapp.service;

import com.niit.chatapp.model.Blog;

public interface BlogService {

Blog findById(int blogid);
    
    Blog findByName(String name);
     
    void saveblog(Blog blog);
     
    void updateblog(Blog blog);
     
    void deleteblogById(int blogid);
    
    public boolean isExistBlog(Blog blog);
}
