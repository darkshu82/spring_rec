package com.tjoeun.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.tjoeun.beans.BoardInfoTable;

public interface TopMenuMapper {
	
	@Select("SELECT BOARD_INFO_IDX, BOARD_INFO_NAME FROM BOARD_INFO_TABLE ORDER BY BOARD_INFO_IDX")
	List<BoardInfoTable> getTopMenuList();

}







