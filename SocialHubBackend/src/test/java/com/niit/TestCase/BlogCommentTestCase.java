package com.niit.TestCase;

import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.BlogCommentDAO;
import com.niit.Model.Blog;
import com.niit.Model.BlogComment;

public class BlogCommentTestCase
{
static BlogCommentDAO blogCommentDAO;
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
}
@Ignore
@Test
public void addBlogCommentTestCase()
{
	BlogComment blogComment=new BlogComment();
	blogComment.setBlogId(1);
	blogComment.setCommentDate(new java.util.Date());
	blogComment.setLoginname("dhinesh");
	blogComment.setCommentText("Very Informative Blog");
	
	assertTrue("Problem in Adding a Blog Comment",blogCommentDAO.addComment(blogComment));
	System.out.println("successfully Printed");
	
}
@Test
public void listBlogCommentTestCase()
{
	List<BlogComment> listComments=blogCommentDAO.getAllComments(1);
	assertTrue("Problem in Listing BlogsComments",listComments.size()>0);
	for(BlogComment blogComment:listComments)
	{
		System.out.print(blogComment.getBlogId()+":::");
		System.out.println(blogComment.getCommentText());
	}
}
}
