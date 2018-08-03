package com.niit.Dao;

import java.util.List;

import com.niit.Model.ForumComment;

public interface ForumCommentDAO
{
	public boolean addComment(ForumComment forumComment);
	public boolean deleteComment(ForumComment forumComment);
	public List<ForumComment> getAllComments(int forumId);
}
