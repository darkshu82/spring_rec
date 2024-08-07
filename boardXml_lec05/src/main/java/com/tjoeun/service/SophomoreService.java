package com.tjoeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.beans.Sophomore;
import com.tjoeun.dao.SophomoreDAO;

@Service
public class SophomoreService {
	
	@Autowired
	private SophomoreDAO sophomoreDAO;
	
	public List<Sophomore> selectAll(){
		List<Sophomore> sophomoreList = sophomoreDAO.selectAll();
		System.out.println("sophomoreList (service) : " + sophomoreList);
		return sophomoreList;
	}

}
