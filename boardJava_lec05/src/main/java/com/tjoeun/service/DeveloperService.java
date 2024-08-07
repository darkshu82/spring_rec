package com.tjoeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.beans.Developer;
import com.tjoeun.dao.DeveloperDAO;

@Service
public class DeveloperService {
	
	@Autowired
	private DeveloperDAO developerDAO;
	
	public List<Developer> selectAll(){
		List<Developer> developerList = developerDAO.selectAll();
		return developerList;
	}
	

}
