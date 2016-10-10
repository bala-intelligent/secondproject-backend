package com.niit.chatapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatapp.model.Blog;

@Repository
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public Blog findById(int blogid) {
		return(Blog)session.getCurrentSession().get(Blog.class,blogid);
	}

	@Override
	public Blog findByName(String blogname) {
		
		return(Blog)session.getCurrentSession().createQuery("from Blog where blogname='"+blogname+"'");
	}

	@Override
	public void saveblog(Blog blog) {
		session.getCurrentSession().saveOrUpdate(blog);
		
	}

	@Override
	public void updateblog(Blog blog) {
		session.getCurrentSession().saveOrUpdate(blog);
		
	}

	@Override
	public void deleteblogById(int blogid) {
		session.getCurrentSession().delete(blogid);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExistBlog(Blog blog) {
		boolean checkblog=false;
		Query q=session.getCurrentSession().createQuery("from Blog where blogid='"+blog.getBlogid()+"' ");
		List<Blog>blogs=q.list();
		int size=blogs.size();
		if(size==0)
		{
			checkblog=true;
		}
		return checkblog;
	}

}
