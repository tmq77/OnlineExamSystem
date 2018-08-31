package service;

import org.springframework.dao.DataAccessException;

public interface AddRequiredService {
	
	public int AddRequired(String course,String allTitle,String allRight)throws DataAccessException;

}
