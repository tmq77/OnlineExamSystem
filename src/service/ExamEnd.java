package service;

import org.springframework.dao.DataAccessException;

public interface ExamEnd {
	public int saveScore(int bScore,String name)throws DataAccessException;

}
