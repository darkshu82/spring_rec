package com.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.beans.Officer;

@Repository	
public class OfficerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Officer> selectAll(){
		List<Officer> officerList = 
				sqlSessionTemplate.selectList("officer.selectAll");
		System.out.println("officerList (dao) : " + officerList);
		return officerList;
	}
	
	

}
