package com.niit.chatapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatapp.model.Forum;
import com.niit.chatapp.model.Friend;
@Transactional
@Repository
public class ForumDaoImpl implements ForumDao {

	@Autowired
	private SessionFactory session;
	@Override
	public Forum findById(int forumid) {
		
		return(Forum)session.getCurrentSession().get(Forum.class,forumid);
	}

	@Override
	public Forum findByName(String name) {
		
		return(Forum)session.getCurrentSession().createQuery("from UserDetails where name='"+name+"'");
	}

	@Override
	public void saveforum(Forum forum) {
		
		session.getCurrentSession().saveOrUpdate(forum);
	}

	@Override
	public void updateforum(Forum forum) {
		
		session.getCurrentSession().saveOrUpdate(forum);
	}

	@Override
	public void deleteforumById(int forumid) {
		session.getCurrentSession().delete(forumid);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAllforum() {
		
		return session.getCurrentSession().createQuery("from Forum").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExistForum(Forum forum) {
		boolean checkForum=false;
		Query q=session.getCurrentSession().createQuery("from Blog where Forum='"+forum.getForumid()+"'");
		List<Friend>friends=q.list();
		int size=friends.size();
		if(size==0)
		{
			checkForum=true;
		}
		return checkForum;
	}

}
