package service.impl;

import mapper.AddRequiredDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.AddRequiredService;

/**
 * 添加必答题
 * @author taominqi
 *
 */
@Transactional
@Service("addRequiredImpl")
public class AddRequiredImpl implements AddRequiredService{
	
	@Autowired
	private AddRequiredDao addRequiredDao; 

	@Override
	public int AddRequired(String course, String allTitle, String allRight)
			throws DataAccessException {
		int flag=addRequiredDao.AddRequiredQs(course, allTitle, allRight);
		if(flag==0){
			return -1;
		}

		return 1;
	}

}
