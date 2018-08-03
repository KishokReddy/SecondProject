package com.niit.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.UserDetail;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean registerUser(UserDetail userDetail)
	{
		try 
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}

	public boolean updateUser(UserDetail userDetail)
	{
		try 
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}

	public UserDetail getUser(String loginname)
	{
		Session session=sessionFactory.openSession();
		UserDetail userDetail=(UserDetail)session.get(UserDetail.class,loginname);
		session.close();
		return userDetail;
	}

	public UserDetail checkUser(UserDetail userDetail)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail where loginname=:myloginname and password=:password");
		query.setParameter("myloginname",userDetail.getLoginname());
		query.setParameter("password",userDetail.getPassword());
		List<UserDetail> listUserDetail=query.list();
		UserDetail userDetail1=listUserDetail.get(0);
		return userDetail1;
	}

}
