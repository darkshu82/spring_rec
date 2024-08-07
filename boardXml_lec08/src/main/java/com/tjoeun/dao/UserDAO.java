package com.tjoeun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String checkUserIdExist(String user_id) {
		String user_name = sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id);
		return user_name;
	}
	
	public void insertUser(UserDTO joinUserDTO) {
		sqlSessionTemplate.insert("user.insertUser", joinUserDTO);
	}
	
	
}
