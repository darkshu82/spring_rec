package com.tjoeun.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.dto.ContentDTO;
import com.tjoeun.mapper.BoardMapper;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper boardMapper;
	
  public void insertContent(ContentDTO writeContentDTO) {
  	boardMapper.insertContent(writeContentDTO);
  }
}


