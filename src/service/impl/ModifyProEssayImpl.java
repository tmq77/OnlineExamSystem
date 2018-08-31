package service.impl;

import mapper.ModifyProEssayDao;
import model.ProEssay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ModifyProEssay;

@Transactional
@Service("modifyProEssayImpl")
public class ModifyProEssayImpl implements ModifyProEssay{

	@Autowired
	private ModifyProEssayDao modifyProEssayDao;
	
	public int modifyPro(String essayTitle, String essayRight, int essayId,String post) {
		ProEssay proEssay = new ProEssay(essayTitle, essayRight,post, essayId);
		
		return modifyProEssayDao.modifyProDao(proEssay);
	}

	

}
