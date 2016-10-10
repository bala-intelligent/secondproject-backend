package com.niit.chatapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.chatapp.dao.FriendDao;
import com.niit.chatapp.model.Friend;
@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDao frienddao;
	
	@Override
	public Friend findById(int friendid) {
		
		return frienddao.findById(friendid);
	}

	@Override
	public Friend findByName(String name) {
		return frienddao.findByName(name);
	}

	@Override
	public void savefriend(Friend friend) {
		frienddao.savefriend(friend);
	}

	@Override
	public void updatefriend(Friend friend) {
		frienddao.updatefriend(friend);
	}

	@Override
	public void deletefriendById(int friendid) {
		frienddao.deletefriendById(friendid);
	}

	@Override
	public List<Friend> findAllfriend() {
		
		return frienddao.findAllfriend();
	}

	@Override
	public boolean isFriendExist(Friend friend) {
		
		return frienddao.isFriendExist(friend);
	}

}
