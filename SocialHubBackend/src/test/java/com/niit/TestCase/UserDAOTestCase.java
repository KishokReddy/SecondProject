package com.niit.TestCase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.UserDAO;
import com.niit.Model.UserDetail;



public class UserDAOTestCase
{
	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}
	@Ignore
	@Test
	public void registerUserTestCase()
	{
		UserDetail userDetail=new UserDetail();
		
		userDetail.setLoginname("kishok");
		userDetail.setPassword("pass123");
		userDetail.setUsername("kishok");
		userDetail.setEmailid("kishok@gmail.com");
		userDetail.setRole("ROLE_ADMIN");
		userDetail.setAddress("chennai");
		userDetail.setMobile("9654654555");
		
		assertTrue("Problem in Registering the User:",userDAO.registerUser(userDetail));
		System.out.println("Successfully Register");
	}
	@Ignore
	@Test
	public void updateUserTestCase()
	{
		UserDetail userDetail=userDAO.getUser("kishok");
		userDetail.setMobile("6845652655");
		
		assertTrue("Problem in Updating User:",userDAO.updateUser(userDetail));
		System.out.println("Successfully Register Updated");
	}
	//@Ignore
	@Test
	public void checkLoginTestCase()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setLoginname("kishok");
		userDetail.setPassword("pass123");
		
		UserDetail userDetail1=userDAO.checkUser(userDetail);
		
		assertNotNull("Problem in loginCheck",userDetail1);
		System.out.println("User Name:"+userDetail1.getUsername());
		System.out.println("User Role:"+userDetail1.getRole());
	}
}
