package com.ning.dao;

import java.util.List;

import com.ning.model.User;

public interface UserMapper extends SqlMapper{
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> queryUser();
}