package com.tjoeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.beans.BoardInfoTable;
import com.tjoeun.dao.TopMenuDAO;

@Service
public class TopMenuService {
	
	@Autowired
	TopMenuDAO topMenuDAO;  

	public List<BoardInfoTable> getTopMenuList(){
		// return topMenuMapper.getTopMenuList();
  	List<BoardInfoTable> topMenuList = topMenuDAO.getTopMenuList();
  	System.out.println("topMenuList (service) : " + topMenuList);
  	return topMenuList;
	}
	
}



