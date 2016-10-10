package com.niit.chatapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.chatapp.dao.BlogDao;
import com.niit.chatapp.model.Blog;
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogdao;
	
	@Override
	public Blog findById(int blogid) {
		
		return blogdao.findById(blogid);
	}

	@Override
	public Blog findByName(String name) {
		
		return blogdao.findByName(name);
	}

	@Override
	public void saveblog(Blog blog) {
		blogdao.saveblog(blog);
		
	}

	@Override
	public void updateblog(Blog blog) {
		blogdao.updateblog(blog);
		
	}

	@Override
	public void deleteblogById(int blogid) {
		blogdao.deleteblogById(blogid);
		
	}

	@Override
	public boolean isExistBlog(Blog blog) {
		
		return blogdao.isExistBlog(blog);
	}

}
