package service;

import org.springframework.dao.DataAccessException;

public interface GetStaff {
	
	int getStaff(String username,String name,String post,String mail)throws DataAccessException;

}
