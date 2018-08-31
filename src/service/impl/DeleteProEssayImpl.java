package service.impl;

import mapper.DeleteProEssayDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.DeleteProEssay;

@Transactional
@Service("deleteProEssayImpl")
public class DeleteProEssayImpl implements DeleteProEssay {
	
	@Autowired
	private DeleteProEssayDao deleteProEssayDao;
	
	public int deletePro(int essayId) {
		
		return deleteProEssayDao.deleteBaseEssay(essayId);
	}

}
