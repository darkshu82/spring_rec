package com.tjoeun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.beans.BoardInfoTable;
import com.tjoeun.mapper.TopMenuMapper;

@Repository
public class TopMenuDAO {
	
	@Autowired
	private TopMenuMapper topMenuMapper;
	
	// DAO 의 메소드에서 TopMenuMapper 의 
	// getTopMenuList() 메소드를 호출함
	
	public List<BoardInfoTable> getTopMenuList(){
		// return topMenuMapper.getTopMenuList();
  	List<BoardInfoTable> topMenuList = topMenuMapper.getTopMenuList();
  	System.out.println("topMenuList (dao) : " + topMenuList);
  	return topMenuList;
	}
	
	
}





