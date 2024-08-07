package com.tjoeun.dao;

import java.util.List;

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
  
  public String getBoardName(int board_info_idx) {
    return boardMapper.getBoardName(board_info_idx); 	
  }
  
  public List<ContentDTO> getContentList(int content_board_idx){
  	List<ContentDTO> contentList = boardMapper.getContentList(content_board_idx);
  	return contentList;
  }
  
  public ContentDTO getContent(int content_idx) {
  	return boardMapper.getContent(content_idx);
  }
  
}




