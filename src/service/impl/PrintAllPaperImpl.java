package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mapper.PrintExamPaperDao;
import model.GetAnswerData;
import model.GetRequiredAnswer;
import model.PaperBaseQs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.PrintAllPaper;

@Transactional
@Service("printAllPaperImpl")
public class PrintAllPaperImpl implements PrintAllPaper{

	@Autowired
	private PrintExamPaperDao printExamPaperDao;
	
	public Map<String, Object> printExamPaper(String username) {
		Map<String,Object> map = new HashMap<>();
		ArrayList<PaperBaseQs> singleQs = new ArrayList<>();  //存放单选
		ArrayList<GetAnswerData> proExam = new ArrayList<>();//存放专业简答
		ArrayList<GetAnswerData > baseExam = new ArrayList<>();//存放基础简答
		GetRequiredAnswer requiredExam = new GetRequiredAnswer();//综合题
	
		singleQs = printExamPaperDao.getSingleQs(username);
		proExam = printExamPaperDao.getProExam(username);
		baseExam = printExamPaperDao.getBaseExam(username);
		requiredExam = printExamPaperDao.getRequiredExam(username);
		
		map.put("singleQs", singleQs);
		map.put("proExam", proExam);
		map.put("baseExam", baseExam);
		map.put("requiredExam",requiredExam);
		
		return map;
	}
	
}
