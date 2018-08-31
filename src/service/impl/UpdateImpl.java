package service.impl;

import mapper.UpdateDao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.Update;

/**
 * @author Administrator
 *
 */
@Transactional
@Service("updateImpl")
public class UpdateImpl implements Update{

	@Autowired
	private UpdateDao updateDao;
	
	
	public void update(String name, String username, String password,
			String post,String id,String mail) {
		updateDao.updateUser(id, name, username, password, post,mail);
	}

}
