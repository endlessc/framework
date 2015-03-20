package com.ning.dao;

import com.ning.model.User;

public class UserDAO extends ParentDAO{

	public User getUserById(int id){
		
		return null;
	}
	
	public User getUserByName(String name){
		
		return null;
	}
	
	public boolean saveUser(User user)  throws Exception{
	
		this.getSessionFactory().getCurrentSession().save(user);
	
		if(user.getId()!=null){
			return true;
		}
		return false;
	}
}
