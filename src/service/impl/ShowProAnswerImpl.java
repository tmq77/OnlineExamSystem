package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.ShowProAnswerDao;
import model.GetAnswerData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ShowProAnswer;

@Transactional
@Service("showProAnswerImpl")
public class ShowProAnswerImpl implements ShowProAnswer{

	@Autowired
	private ShowProAnswerDao showProAnswerDao;
	
	public List<GetAnswerData> showProAnswer(String account) {
		
		ArrayList<GetAnswerData> answer = new ArrayList<GetAnswerData>();
		answer = showProAnswerDao.showProAns(account);
		return answer;
	}

}
