package com.niit.Dao;

import com.niit.Model.ProfilePicture;

public interface ProfilePictureDAO
{
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String loginname);
}
