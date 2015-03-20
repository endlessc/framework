package com.ning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.dao.UserDAO;
import com.ning.model.User;

@Service
public class UserService {
	
	@Autowired
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
		
		System.out.println("*******user service*********");
		
		return this.userDAO.saveUser(user);
	}
}
