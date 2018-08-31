package service.impl;

import mapper.AddProQsDao;
import model.SaveProEssay;
import model.SingleQs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ProQs;

@Transactional
@Service("proQsImpl")
public class ProQsImpl implements ProQs {

	@Autowired
	private  AddProQsDao addProQsDao;

	
	/**
	 * @return -1 失败<br>
	 * 1 成功
	 * 
	 */
	public int addProQs(String course, String question_type, String sTitle,
			String sOptionA, String sOptionB, String sOptionC, String sOptionD,
			String single_right, String eTitle, String eRight) {
		if ("1".equals(question_type)) {
			
			SingleQs singleQs = new SingleQs(sTitle, sOptionA, sOptionB, sOptionC, sOptionD, single_right,course);
			addProQsDao.addSingle(singleQs);
		} else if ("2".equals(question_type)) {
			SaveProEssay saveProEssay = new SaveProEssay(eTitle, eRight, course);
			addProQsDao.addEssay(saveProEssay);
		}
		return 1;
	}
}
