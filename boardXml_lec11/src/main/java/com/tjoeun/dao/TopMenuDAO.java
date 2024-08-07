package com.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.dto.BoardInfoDTO;

@Repository
public class TopMenuDAO {
	/*
	@Autowired
	private TopMenuMapper topMenuMapper;
	*/
	
	// Xml 방식에서는 SqlSessionTemplate 을 사용함
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// DAO 의 메소드에서 TopMenuMapper 의 
	// getTopMenuList() 메소드를 호출함
	
	public List<BoardInfoDTO> getTopMenuList(){
		// return topMenuMapper.getTopMenuList();
  	List<BoardInfoDTO> topMenuList = sqlSessionTemplate.selectList("topmenu.getTopMenuList");
  	System.out.println("topMenuList (dao) : " + topMenuList);
  	return topMenuList;
	}
	
	
}





