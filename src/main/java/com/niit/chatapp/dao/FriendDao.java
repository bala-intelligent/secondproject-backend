package com.niit.chatapp.dao;

import java.util.List;

import com.niit.chatapp.model.Friend;

public interface FriendDao {

Friend findById(int friendid);
    
    Friend findByName(String name);
     
    void savefriend(Friend friend);
     
    void updatefriend(Friend friend);
     
    void deletefriendById(int friendid);
 
    List<Friend> findAllfriend(); 
     
    public boolean isFriendExist(Friend friend);
}
