package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.ShowBaseAnswerDao;
import model.GetAnswerData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ShowBaseAnswer;

@Transactional
@Service("showBaseAnswerImpl")
public class ShowBaseAnswerImpl implements ShowBaseAnswer{
	@Autowired
	private ShowBaseAnswerDao showBaseAnswerDao;
	
	public List<GetAnswerData> showBaseAnswer(String account) {

		ArrayList<GetAnswerData> answer = new ArrayList<GetAnswerData>();
		answer = showBaseAnswerDao.showBaseAns(account);
		return answer;
	}

}
