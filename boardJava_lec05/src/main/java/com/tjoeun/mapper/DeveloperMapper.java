package com.tjoeun.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.tjoeun.beans.Developer;

public interface DeveloperMapper {

	@Select("SELECT *  FROM DEVELOPER ORDER BY EMPNO")
	List<Developer> selectAll();
	
}
