package com.niit.chatapp.dao;

import java.util.List;

import com.niit.chatapp.model.Forum;

public interface ForumDao {

Forum findById(int forumid);
    
    Forum findByName(String name);
     
    void saveforum(Forum forum);
     
    void updateforum(Forum forum);
     
    void deleteforumById(int userId);
 
    List<Forum> findAllforum(); 
     
   public boolean isExistForum(Forum forum);
}
