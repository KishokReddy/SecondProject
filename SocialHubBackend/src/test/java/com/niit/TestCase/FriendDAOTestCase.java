package com.niit.TestCase;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.FriendDAO;
import com.niit.Model.Friend;
import com.niit.Model.UserDetail;

public class FriendDAOTestCase
{
	static FriendDAO friendDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		friendDAO=(FriendDAO)context.getBean("friendDAO");
		
	}
	//@Ignore
	@Test
	public void sendFriendRequestTestCase()
	{
		Friend friend=new Friend();
		friend.setLoginname("kishok");
		friend.setFriendloginname("dhinesh");
		friend.setStatus("NA");
		assertTrue("Problem in sending Friend Request",friendDAO.sendFriendRequest(friend));
	}
	
	@Ignore
	@Test
	public void acceptFriendRequest()
	{
		assertTrue("Problem in accepting Friend Request",friendDAO.acceptFriendRequest(-39));
	}
	
	@Ignore
	@Test
	public void deleteFriendRequest()
	{
		assertTrue("Problem in deleting Friend Request",friendDAO.deleteFriendRequest(-40));
	}
	
	@Test
	public void showPendingFriend()
	{	System.out.println("---------PENDING FRIEND LIST---------");
		List<Friend> listPendingFriendRequest=friendDAO.showPendingFriendRequest("Dhinesh");
		assertTrue("Problem in showing Pending Friend requests",listPendingFriendRequest.size()>0);
		for(Friend friend:listPendingFriendRequest)
		{
			System.out.print(friend.getLoginname()+"-----");
			System.out.println(friend.getFriendloginname());
		}
	}
	
	@Test
	public void showFriendList()
	{
		List<Friend> friendList=friendDAO.showFriendList("kishok");
		assertTrue("Problem in listing Friends",friendList.size()>0);
		System.out.println("---------FRIENDLIST---------");
		for(Friend friend:friendList)
		{
			System.out.print(friend.getLoginname()+"-----");
			System.out.println(friend.getFriendloginname());
		}
	}
	
	@Test
	public void suggestedFriends()
	{
		List<UserDetail> listUserDetail=(List<UserDetail>)friendDAO.showSuggestedFriend("kishok");
		assertTrue("Problem in suggesting Friends",listUserDetail.size()>0);
		System.out.println("---------SUGGESTED FRIENDS---------");
		for(UserDetail userDetail:listUserDetail)
		{
			System.out.println(userDetail.getLoginname()+"---"+userDetail.getUsername());
		}
	}
}
