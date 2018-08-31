package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.GetAllSingleQsDao;
import model.BaseQs;
import service.GetAllSingleQs;

@Transactional
@Service("getAllSingleQsImpl")
public class GetAllSingleQsImpl implements GetAllSingleQs{

	@Autowired
	private GetAllSingleQsDao getAllSingleQsDao;
	
	public ArrayList<BaseQs> getSingleQsAll(int index) {
		
		return getAllSingleQsDao.getAllQs(index);
	}

	//获取记录数量
	public int getCounts() {
		return getAllSingleQsDao.getCounts();
	}

}
