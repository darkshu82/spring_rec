package com.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.beans.Developer;

@Repository
public class DeveloperDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Developer> selectAll(){
		List<Developer> developerList = 
				sqlSessionTemplate.selectList("developer.selectAll");
		return developerList;
	}
}



