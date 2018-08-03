package com.niit.TestCase;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.ForumCommentDAO;
import com.niit.Model.ForumComment;

public class ForumCommentTestCase
{
	static ForumCommentDAO forumCommentDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
	}
	@Ignore
	@Test
	public void addForumCommentTestCase()
	{
		ForumComment forumComment=new ForumComment();
		forumComment.setForumId(202);
		forumComment.setDiscussionDate(new java.util.Date());
		forumComment.setLoginname("dhinesh");
		forumComment.setDiscussionText("Given Information was usefull");
		
		assertTrue("Problem in Adding a Forum Comment",forumCommentDAO.addComment(forumComment));
		System.out.println("Successfully Printed");
		
	}
	@Test
	public void listForumCommentTestCase()
	{
		List<ForumComment> listComments=forumCommentDAO.getAllComments(953);
		assertTrue("Problem in Listing ForumsComments",listComments.size()>0);
		for(ForumComment forumComment:listComments)
		{
			System.out.print(forumComment.getForumId()+":::");
			System.out.println(forumComment.getDiscussionText());
		}
	}
}
