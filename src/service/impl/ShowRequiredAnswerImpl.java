package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.ShowRequiredAnswerDao;
import model.GetRequiredAnswer;
import service.ShowRequiredAnswer;

@Transactional
@Service("showRequiredAnswerImpl")
public class ShowRequiredAnswerImpl implements ShowRequiredAnswer{

	@Autowired
	private ShowRequiredAnswerDao showRequiredAnswerDao;
	
	@Override
	public GetRequiredAnswer showRequiredAnswer(String account) {
		
		GetRequiredAnswer answer = showRequiredAnswerDao.showReqAns(account);
		return answer;
	}

}
