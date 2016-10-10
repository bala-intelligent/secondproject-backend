package com.niit.chatapp.service;

import java.util.List;

import com.niit.chatapp.model.Friend;
import com.niit.chatapp.model.UserDetails;

public interface FriendService {
Friend findById(int friendid);
    
    Friend findByName(String name);
     
    void savefriend(Friend friend);
     
    void updatefriend(Friend friend);
     
    void deletefriendById(int friendid);
 
    List<Friend> findAllfriend(); 
    
    public boolean isFriendExist(Friend friend);
}
