package service.impl;

import mapper.ModifyBaseEssayDao;
import model.BaseEssay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ModifyBaseEssay;

@Transactional
@Service("modifyBaseEssayImpl")
public class ModifyBaseEssayImpl implements ModifyBaseEssay{

	@Autowired
	private ModifyBaseEssayDao modifyBaseEssayDao;
	
	public int modifyEssay(String essayTitle, String essayRight, int essayId) {
		BaseEssay baseEssay = new BaseEssay(essayTitle, essayRight, essayId);
		
		return modifyBaseEssayDao.modifyBaseDao(baseEssay);
	}

}
