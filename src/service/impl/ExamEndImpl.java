package service.impl;

import mapper.ExamEndDao;
import model.ExamEndModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.UuidGenerator;
import service.ExamEnd;

@Transactional
@Service("examEndImpl")
public class ExamEndImpl implements ExamEnd{
	
	@Autowired
	private ExamEndDao examEndDao;
	
	
	public int saveScore(int bScore, String name)throws DataAccessException {
		String id=UuidGenerator.getUuid();
		ExamEndModel endModel = new ExamEndModel(id,name, bScore); 
	
		examEndDao.examEnd(endModel);

		
		return 0;
	}
	

}
