package service;

import java.util.ArrayList;

import model.BaseEssay;
import model.ModifyRequiredQs;
import model.ProEssay;

public interface Search {

	
	/**查询单选
	 * @param str 输入的查询字符
	 * @return
	 */
	ArrayList<model.BaseQs> getSingleSearch(String str);
	
	/**查询基础简答
	 * @param str
	 * @return
	 */
	ArrayList<BaseEssay> getBaseEssaySearch(String str);
	
	
	/**
	 * 查询专业简答
	 * @param post
	 * @param str
	 * @return
	 */
	ArrayList<ProEssay> getProEssaySearch(String post,String str);
	
	/**查询综合题
	 * @param post
	 * @param str
	 * @return
	 */
	ArrayList<ModifyRequiredQs> getRequiredQsSearch(String post,String str);
}
