package com.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.beans.Sophomore;

@Repository
public class SophomoreDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Sophomore> selectAll(){
		List<Sophomore> sophomoreList = sqlSessionTemplate.selectList("sophomore.selectAll");
		System.out.println("sophomoreList (dao) : " + sophomoreList);
		return sophomoreList;
	}
}


