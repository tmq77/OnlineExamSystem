package service;

import java.util.List;

import model.ExamData;

public interface ShowScore {
	public List<ExamData> showScore(int pageNo);
	
	public int getTotalPage();


}
