package com.tjoeun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.beans.Officer;
import com.tjoeun.dao.OfficerDAO;

@Service
public class OfficerService {
  @Autowired
  private OfficerDAO officerDAO;
  
  public List<Officer> selectAll(){
  	List<Officer> officerList = officerDAO.selectAll();
  	System.out.println("officerList (service) : " + officerList);
  	return officerList;
  }
}



