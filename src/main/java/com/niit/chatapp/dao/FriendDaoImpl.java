package com.niit.chatapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatapp.model.Friend;
@Transactional
@Repository
public class FriendDaoImpl implements FriendDao{

@Autowired	
	private SessionFactory session;
	@Override
	public Friend findById(int friendid) {
		
		return(Friend)session.getCurrentSession().get(Friend.class,friendid);
	}

	@Override
	public Friend findByName(String name) {
		
		return(Friend)session.getCurrentSession().createQuery("from Friend where name='"+name+"'").list();
	}

	@Override
	public void savefriend(Friend friend) {
		session.getCurrentSession().saveOrUpdate(friend);
	}

	@Override
	public void updatefriend(Friend friend) {
		session.getCurrentSession().saveOrUpdate(friend);
	}

	@Override
	public void deletefriendById(int friendid) {
		session.getCurrentSession().delete(friendid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> findAllfriend() {
		
		return session.getCurrentSession().createQuery("from Friend").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isFriendExist(Friend friend) {
		boolean checkfriend=false;
		Query q=session.getCurrentSession().createQuery("from Blog where friend='"+friend.getId()+"'");
		List<Friend>friends=q.list();
		int size=friends.size();
		if(size==0)
		{
			checkfriend=true;
		}
		
		return checkfriend;
	}

}
