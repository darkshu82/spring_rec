package com.tjoeun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.beans.Officer;
import com.tjoeun.mapper.OfficerMapper;

@Repository	
public class OfficerDAO {
	
	@Autowired
	private OfficerMapper officerMapper;
	
	public List<Officer> selectAll(){
		List<Officer> officerList = officerMapper.selectAll();
		System.out.println("officerList (dao) : " + officerList);
		return officerList;
	}
	
	

}
