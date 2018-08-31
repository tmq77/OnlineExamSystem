package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mapper.GetExamQsDao;
import model.BaseQs;
import model.EssayQs;
import model.ProEssayQs;
import model.RequiredQs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.GetExamQs;

/**
 * 业务层，将所有的题目组成试卷返回
 * @author taominqi
 * @time 2017年3月3日15:33:30
 */
@Transactional
@Service("getExamQsImpl")
public class GetExamQsImpl implements GetExamQs{

	//自动装配,使用动态代理将下面的Dao类注入
	@Autowired
	private GetExamQsDao getExamQsDao;
	
	
	
	public Map<String, Object> getAllQs(String post,String username) {
		Map<String,Object> getQs = new HashMap<String, Object>();
		ArrayList<String> corAnswer = new ArrayList<String>();//存放单选答案
		ArrayList<Integer> singleID = new ArrayList<>();//存放取出的试题的id,用于后面存放试卷打印
		//取出逻辑问答
		ArrayList<EssayQs> baseEssay = getExamQsDao.selectBaseEssay(); 
		
		//取出逻辑单选
		ArrayList<BaseQs> baseQs = (ArrayList<BaseQs>) getExamQsDao.selectBaseQs();
		for(int i=0;i<baseQs.size();i++){
			String str=baseQs.get(i).getBaseSingleAS();
			int id = baseQs.get(i).getEid();
			corAnswer.add(str);
			singleID.add(id);
		}	
		
		//取出专业简答
		ArrayList<ProEssayQs> proEssay =  getExamQsDao.selectProEssay(post); 
		
		//取出必答题
		RequiredQs rqs = getExamQsDao.getReQs(post);
		
		//数据放入Map
		getQs.put("baseEssay", baseEssay);
		getQs.put("baseQs", baseQs);
		getQs.put("corAnswer", corAnswer);
		getQs.put("singleID", singleID);
		getQs.put("proEssay", proEssay);
		getQs.put("requiredQs", rqs);
		
		getExamQsDao.modifyStatus(username);
		return getQs;
	}

}
