package service.impl;

import java.util.ArrayList;

import mapper.GetAllrequiredQsDao;
import model.ModifyRequiredQs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.GetAllRequiredQs;

/**
 * 获取所有的综合题的业务层--修改
 * @author taominqi
 *
 */
@Transactional
@Service("getAllRequiredQsImpl")
public class GetAllRequiredQsImpl implements GetAllRequiredQs{

	@Autowired
	private GetAllrequiredQsDao getAllrequiredQsDao;
	
	public int getCounts(String post) {
		return getAllrequiredQsDao.getTotalCounts(post);
	}

	@Override
	public ArrayList<ModifyRequiredQs> getRequiredQs(String post, int index) {
		return getAllrequiredQsDao.allRequiredQs(post, index);
	}

}
