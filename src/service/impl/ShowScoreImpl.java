package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.ShowScoreDao;
import model.ExamData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ShowScore;

@Transactional
@Service("showScoreImpl")
public class ShowScoreImpl implements ShowScore{

	@Autowired
	private ShowScoreDao showScoreDao;
	
	public List<ExamData> showScore(int index) {
	
		ArrayList<ExamData> examData = new ArrayList<ExamData>();
		examData = showScoreDao.getAllScore(index);
		return examData;
	}

	@Override
	public int getTotalPage() {
		int total = showScoreDao.getTotalPage();
		int pageSize = (total%6)==0?(total/6):((total/6)+1);
		return pageSize;
	}

	

}
