package com.ning.service;

import com.ning.dao.UserDAO;
import com.ning.model.User;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean isExsit(User user){
		
		return false;
	}
	
	public boolean addUser (User user)throws Exception{
		return this.userDAO.saveUser(user);
	}
}
