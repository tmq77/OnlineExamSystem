package service.impl;

import java.util.ArrayList;
import mapper.PrintPaperDao;
import model.GetAnswerData;
import model.GetRequiredAnswer;
import model.PaperBaseQs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.UuidGenerator;
import service.PrintPaper;

/**
 * 打印试卷的实现类
 * @author taominqi
 *
 */
@Transactional
@Service("printPaperImpl")
public class PrintPaperImpl implements PrintPaper{
	
	@Autowired
	private PrintPaperDao printPaperDao;

	public int printQs(String username) {
		
		int check = printPaperDao.insertCheck(username);//插入前的确认,防止已经被通过的账号被再次录入出现异常,一般不会用到这句代码
		if(check!=0){ //表中已经有记录了,说明插入过了;
			return -1;
		}
		
		
			//获取题目答案
			ArrayList<PaperBaseQs> singleQs = printPaperDao.printSingleQs(username); //单选
			ArrayList<GetAnswerData> proExam = printPaperDao.printProExam(username);//专业简答
			ArrayList<GetAnswerData > BaseExam = printPaperDao.printBaseExam(username);//基础简答
			GetRequiredAnswer requiredExam = printPaperDao.printRequiredExam(username);//综合题
		
			//插入单选题目和答案
			for(int i=0;i<singleQs.size();i++){
				printPaperDao.insertPrintSingle(singleQs.get(i));
			}
			//插入专业简答题目和答案
			for(int i =0;i<proExam.size();i++){
				GetAnswerData prodata = proExam.get(i);
				printPaperDao.insertPrintProExam(UuidGenerator.getUuid(), username, prodata.geteTitle(), prodata.geteRight(), prodata.getAnswer());
			}
			//插入基础简答的题目和答案
			for(int i = 0;i<BaseExam.size();i++){
				GetAnswerData basedata = BaseExam.get(i);
				printPaperDao.insertPrintBaseExam(UuidGenerator.getUuid(), username, basedata.geteTitle(), basedata.geteRight(), basedata.getAnswer());
			}
			
			printPaperDao.insertPrintRequiredExam(UuidGenerator.getUuid(), username , requiredExam.getTitle(), requiredExam.getRright(), requiredExam.getRanswer());
			printPaperDao.insertPrintAudioExam(UuidGenerator.getUuid(), requiredExam.getVanswer(), username);
		
		return 0;
	}

}
