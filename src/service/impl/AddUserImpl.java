package service.impl;

import mapper.AddUserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.DateUtil;
import Handler.UuidGenerator;
import service.AddUser;

@Transactional
@Service("addUserImpl")
public class AddUserImpl implements AddUser{
	
	@Autowired
	private AddUserDao addUserDao;
	/**
	 * @return -1 录入失败<br>
	 * 1 录入成功
	 */
	public int addInterviewer(String name, String username, String password,
			String post,String mail) {
		try{
			String uid = UuidGenerator.getUuid();
		int i =addUserDao.addUser(uid,name, username, password, post,mail,DateUtil.getDateTime());
		if(i==0){
			return -1;
		}
		}catch(Exception e){
			System.out.println(e);
			return -1;
		}
		return 1;		
	}
}
