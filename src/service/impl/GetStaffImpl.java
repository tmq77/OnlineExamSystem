package service.impl;

import mapper.GetStaffDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.UuidGenerator;
import service.GetStaff;

@Transactional
@Service("getStaffImpl")
public class GetStaffImpl implements GetStaff{

	@Autowired
	private GetStaffDao getStaffDao;
	

	
	public int getStaff(String username, String name, String post,String mail) {
		
		int flag = getStaffDao.insertStaff(UuidGenerator.getUuid(), name, username, post,mail);
		if(flag==-1){
			return -1;
		}
		
		return 0;
	}

}
