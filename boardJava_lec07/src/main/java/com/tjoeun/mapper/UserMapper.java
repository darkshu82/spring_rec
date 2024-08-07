package com.tjoeun.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	
	@Select("SELECT USER_NAME " +
          "FROM USER_TABLE " +
          "WHERE USER_ID=#{user_id}")
	String checkUserIdExist(String user_id);
	
}
