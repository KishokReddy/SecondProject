package com.niit.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addComment(ForumComment forumComment) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
}
	public boolean deleteComment(ForumComment forumComment)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}	
	}

	public List<ForumComment> getAllComments(int forumId)
	{
	try
	{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from ForumComment");
	List<ForumComment> listForumComments=query.list();
	return listForumComments;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised"+e);
		return null;
	}
	}
}