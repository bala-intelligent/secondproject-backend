package com.niit.chatapp.service;

import java.util.List;

import com.niit.chatapp.model.Forum;

public interface ForumService {
Forum findById(int forumid);
    
    Forum findByName(String name);
     
    void saveforum(Forum forum);
     
    void updateforum(Forum forum);
     
    void deleteforumById(int userId);
 
    List<Forum> findAllforum(); 
    
    public boolean isExistForum(Forum forum);
}
