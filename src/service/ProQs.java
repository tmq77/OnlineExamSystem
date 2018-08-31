package service;

import org.springframework.dao.DataAccessException;

public interface ProQs {
	
	public int addProQs(String course,String question_type,String sTitle,String sOptionA,String sOptionB,String sOptionC,String sOptionD,String single_right,String eTitle,String eRight)throws DataAccessException;

}
