package service.impl;

import mapper.DeleteBaseEssayDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.DeleteBaseEssay;

@Transactional
@Service("deleteBaseEssayImpl")
public class DeleteBaseEssayImpl implements DeleteBaseEssay{
	
	@Autowired
	private DeleteBaseEssayDao deleteBaseEssayDao;
	
	public int deleteBase(int essayId) {
		
		return deleteBaseEssayDao.deleteBaseEssay(essayId);
	}

}
