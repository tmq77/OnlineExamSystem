package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.UuidGenerator;
import mapper.ExamEndDao;
import mapper.InsertSingleQsTempDao;
import mapper.SaveBaseAnswerDao;
import mapper.SaveProAnswerDao;
import mapper.SaveRequiredAnswerDao;
import model.ExamEndModel;
import model.InsertBaseAnswer;
import model.InsertProAnswer;
import model.InsertRequiredAnswer;
import model.PaperBaseQs;
import service.InsertExamAnswer;

@Transactional
@Service("insertExamAnswerImpl")
public class InsertExamAnswerImpl implements InsertExamAnswer{

	@Autowired
	private ExamEndDao examEndDao;
	
	@Autowired
	private SaveProAnswerDao saveProAnswer;
	
	@Autowired
	private SaveBaseAnswerDao saveBaseAnswerDao;
	
	@Autowired
	private SaveRequiredAnswerDao saveRequiredAnswerDao;
	
	@Autowired
	private InsertSingleQsTempDao insertSingleQsTempDao;
	
	public int insertExamSafely(int score, String username, String proId1,
			String proId2, String proId3, String proAns1, String proAns2,
			String proAns3, String baseId1, String baseId2, String baseId3,
			String baseAns1, String baseAns2, String baseAns3, String rid,
			String reanswer, String voiceanswer, String[] temp,
			ArrayList<Integer> singleID) {


			
			ExamEndModel endModel = new ExamEndModel(UuidGenerator.getUuid(),username, score); 
			if(examEndDao.examEnd(endModel)==0){
				throw new RuntimeException();
			}
			
			

		
			InsertProAnswer insertProAnswer1 = new InsertProAnswer(UuidGenerator.getUuid(),username, proId1, proAns1);
			InsertProAnswer insertProAnswer2 = new InsertProAnswer(UuidGenerator.getUuid(),username, proId2, proAns2);
			InsertProAnswer insertProAnswer3 = new InsertProAnswer(UuidGenerator.getUuid(),username, proId3, proAns3);
			
			if(saveProAnswer.saveProAnswer(insertProAnswer1)==0){
				throw new RuntimeException();  //spring只能默认捕获运行中异常，不能使用try-catch-如果使用了try-catch,那么需要在catch块中抛出运行中异常才能自动回滚
			}
			if(saveProAnswer.saveProAnswer(insertProAnswer2)==0){
				throw new RuntimeException();
			}
			if(saveProAnswer.saveProAnswer(insertProAnswer3)==0){
				throw new RuntimeException();
			}
			
			 
			
			InsertBaseAnswer insertBaseAnswer1 = new InsertBaseAnswer(UuidGenerator.getUuid(),username, baseId1, baseAns1);
			InsertBaseAnswer insertBaseAnswer2 = new InsertBaseAnswer(UuidGenerator.getUuid(),username, baseId2, baseAns2);
			InsertBaseAnswer insertBaseAnswer3= new InsertBaseAnswer(UuidGenerator.getUuid(),username, baseId3, baseAns3);
			
				if(saveBaseAnswerDao.saveBaseAnswer(insertBaseAnswer1)==0){
					throw new RuntimeException();
				}
				if(saveBaseAnswerDao.saveBaseAnswer(insertBaseAnswer2)==0){
					throw new RuntimeException();
				}
				if(saveBaseAnswerDao.saveBaseAnswer(insertBaseAnswer3)==0){
					throw new RuntimeException();
				}
				
				 
				InsertRequiredAnswer insertRequiredAnswer = new InsertRequiredAnswer(UuidGenerator.getUuid(),rid, reanswer, username);
				if(saveRequiredAnswerDao.saveRequiredAnswer(insertRequiredAnswer)==0){
					throw new RuntimeException();
				}
				if(saveRequiredAnswerDao.saveAudioAnswer(UuidGenerator.getUuid(), voiceanswer,username)==0){
					throw new RuntimeException();
				}
				
				for(int i=0;i<singleID.size();i++){
					PaperBaseQs paperBaseQs = insertSingleQsTempDao.getBaseSingle(singleID.get(i));
					paperBaseQs.setAccount(username);
					paperBaseQs.setSingleUs(temp[i]);
					paperBaseQs.setUuid(UuidGenerator.getUuid());
					int flag = insertSingleQsTempDao.insertSingleTemp(paperBaseQs);
					if(flag==0){
						throw new RuntimeException();
					}
				}
		
		return 0;
	}

}
