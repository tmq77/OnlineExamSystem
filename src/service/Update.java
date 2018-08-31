package service;

import org.springframework.dao.DataAccessException;

public interface Update {
	public void update(String name,String username,String password,String post,String id,String mail)throws DataAccessException;

}
