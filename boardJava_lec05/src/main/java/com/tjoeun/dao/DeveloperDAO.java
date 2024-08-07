package com.tjoeun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.beans.Developer;
import com.tjoeun.mapper.DeveloperMapper;

@Repository
public class DeveloperDAO {
	
	@Autowired
	private DeveloperMapper developerMapper;
	
	public List<Developer> selectAll(){
		List<Developer> developerList = developerMapper.selectAll();
		System.out.println("developerList (dao) : " + developerList);
		return developerList;
	}
}



