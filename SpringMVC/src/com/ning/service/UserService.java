package com.ning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.dao.UserMapper;
import com.ning.model.User;

/**
 * 
 * @author Administrator
 *
 */
@Service
public class UserService  {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 
	 * @return
	 */
	public List<User> findUser() {
		return this.userMapper.queryUser();
	}

	/**
	 * 
	 * @param user
	 */
	public void saveUser(User user) {

		this.userMapper.insert(user);
	}

}
