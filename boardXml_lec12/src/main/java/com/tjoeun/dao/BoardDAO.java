package com.tjoeun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.dto.ContentDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
  public void insertContent(ContentDTO writeContentDTO) {
  	sqlSessionTemplate.insert("board.insertContent", writeContentDTO);
  }
}


