package com.niit.chatapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.chatapp.dao.ForumDao;
import com.niit.chatapp.model.Forum;
@Service
public class ForumServiceImpl implements ForumService{
@Autowired
	private ForumDao forumdao;

	@Override
	public Forum findById(int forumid) {
		
		return forumdao.findById(forumid);
	}

	@Override
	public Forum findByName(String name) {
		
		return forumdao.findByName(name);
	}

	@Override
	public void saveforum(Forum forum) {
		
		forumdao.saveforum(forum);
	}

	@Override
	public void updateforum(Forum forum) {
		forumdao.updateforum(forum);
		
	}

	@Override
	public void deleteforumById(int userId) {
		
		forumdao.deleteforumById(userId);
	}

	@Override
	public List<Forum> findAllforum() {
		
		return forumdao.findAllforum();
	}

	@Override
	public boolean isExistForum(Forum forum) {
		
		return forumdao.isExistForum(forum);
	}

}
