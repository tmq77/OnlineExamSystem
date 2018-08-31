package service.impl;

import java.util.ArrayList;

import mapper.GetAllProEssayDao;
import model.ProEssay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.GetAllProEssay;

@Transactional
@Service("getAllProEssayImpl")
public class GetAllProEssayImpl implements GetAllProEssay{

	@Autowired
	private GetAllProEssayDao getAllProEssayDao;
	
	public ArrayList<ProEssay> getAllPro(String post,int index) {
		
		return getAllProEssayDao.allProEssay(post,index);
		
	}

	public int getCounts(String post) {
		
		return getAllProEssayDao.getTotalCounts(post);
	}
	
	
	

	
}
