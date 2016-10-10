package com.niit.chatapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatapp.model.UserDetails;
@Repository
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {
@Autowired
private SessionFactory session;

	@Override
	public UserDetails findById(int userId) {
		
		return(UserDetails)session.getCurrentSession().get(UserDetails.class,userId);
	}

	@Override
	public UserDetails findByName(String name) {
		
		return(UserDetails)session.getCurrentSession().createQuery("from UserDetails where name='"+name+"'");
	}

	@Override
	public void saveUser(UserDetails userDetails) {
		session.getCurrentSession().saveOrUpdate(userDetails);
		
	}

	@Override
	public void updateUser(UserDetails userDetails) {
		session.getCurrentSession().saveOrUpdate(userDetails);
		
	}

	@Override
	public void deleteUserById(int userId) {
		session.getCurrentSession().delete(userId);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> findAllUsers() {
		
		return session.getCurrentSession().createQuery("from UserDetails").list();
	}

	@Override
	public void deleteAllUsers(UserDetails userDetails) {
		session.getCurrentSession().delete(userDetails);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUserExist(UserDetails userDetails) {
		boolean checkuser=false;
       Query q=session.getCurrentSession().createQuery("from UserDetails  where email_id='"+userDetails.getEmail_id()+"'");
		List<UserDetails> userdetails=q.list();
		int size=userdetails.size();
		if(size==0)
		{
			checkuser=true;
		}
		return checkuser;
	}
	
}
