package com.bway.twotier.dao;

import com.bway.twotier.model.User;

public interface Userdao {

	void Usersignup(User u);
	
	boolean Userlogin(String un, String pw);
	
	
}
