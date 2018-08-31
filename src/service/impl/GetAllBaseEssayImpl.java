package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.GetAllBaseEssayDao;
import model.BaseEssay;
import service.GetAllBaseEssay;

@Transactional
@Service("getAllBaseEssayImpl")
public class GetAllBaseEssayImpl implements GetAllBaseEssay{

	@Autowired
	private GetAllBaseEssayDao getAllBaseEssayDao;
	
	public ArrayList<BaseEssay> getAllBaseEssay(int index) {
		
		return getAllBaseEssayDao.getBaseEssay(index);
	}
	
	public int getTotalCounts(){
		return getAllBaseEssayDao.getCounts();
	}

}
