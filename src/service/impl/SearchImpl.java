package service.impl;

import java.util.ArrayList;

import mapper.SearchDao;
import model.BaseEssay;
import model.BaseQs;
import model.ModifyRequiredQs;
import model.ProEssay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.Search;

@Transactional
@Service("searchImpl")
public class SearchImpl implements Search{

	@Autowired
	private SearchDao searchDao;
	
	/**
	 * 单选题模糊搜索
	 */
	public ArrayList<BaseQs> getSingleSearch(String str) {
			return searchDao.getSingleSearch(str);
	}

	/**
	 * 基础简答模糊搜索
	 */
	public ArrayList<BaseEssay> getBaseEssaySearch(String str) {
		return searchDao.getBaseEssaySearch(str);
	}

	/**
	 * 专业简答模糊搜索
	 */
	public ArrayList<ProEssay> getProEssaySearch(String post, String str) {
		return searchDao.getProEssaySearch(post, str);
	}

	/**
	 * 综合题模糊搜索
	 */
	public ArrayList<ModifyRequiredQs> getRequiredQsSearch(String post, String str) {
		
		return searchDao.getRequiredSearch(post, str);
	}

}
