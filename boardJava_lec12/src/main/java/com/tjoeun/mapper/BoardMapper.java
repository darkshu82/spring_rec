package com.tjoeun.mapper;

import org.apache.ibatis.annotations.Insert;

import com.tjoeun.dto.ContentDTO;

public interface BoardMapper {
  
	@Insert("INSERT INTO CONTENT_TABLE "
			    + "VALUES(CONTENT_SEQ.NEXTVAL, "
			    + "#{content_subject}, #{content_text}, "
			    + "#{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, "
			    + "#{content_board_idx}, SYSDATE)")
	void insertContent(ContentDTO writeContentDTO);
	
	
	
}
