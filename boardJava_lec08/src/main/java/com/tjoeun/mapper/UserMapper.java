package com.tjoeun.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.tjoeun.dto.UserDTO;

public interface UserMapper {
	
	@Select("SELECT USER_NAME " +
          "FROM USER_TABLE " +
          "WHERE USER_ID=#{user_id}")
	String checkUserIdExist(String user_id);
	
	@Insert("INSERT INTO USER_TABLE " +
          "VALUES(USER_SEQ.NEXTVAL, #{user_name}, #{user_id}, #{user_pw})")
	void insertUser(UserDTO joinUserDTO);
	
}



