package com.niit.Dao;

import java.util.List;

import com.niit.Model.BlogComment;

public interface BlogCommentDAO
{
public boolean addComment(BlogComment blogComment);
public boolean deleteComment(BlogComment blogComment);
public List<BlogComment> getAllComments(int blogId);
}
