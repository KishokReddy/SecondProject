package com.niit.Dao;

import java.util.List;

import com.niit.Model.Blog;

public interface BlogDAO 
{
public boolean addBlog(Blog blog);
public boolean deleteBlog(Blog blog);
public boolean updateBlog(Blog blog);
public Blog getBlog(int blogId);
public List<Blog> listBlogs();

public boolean approveBlog(int blogId);
public boolean rejectBlog(int blogId);

public boolean incLikes(int blogId);
public boolean disLikes(int blogId);
}
