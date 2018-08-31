package service;

import java.util.Map;

/**
 * 打印试卷----取出所有在打印表中的试卷
 * @author taominqi
 *
 */
public interface PrintAllPaper {
	
	public Map<String,Object> printExamPaper(String username);

}
