package service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import mapper.ModifyAdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.Md5Encoder;
import service.ModifyAdmin;

@Transactional
@Service("modifyAdminImpl")
public class ModifyAdminImpl implements ModifyAdmin{

	@Autowired
	private ModifyAdminDao modifyAdminDao;
	
	public int modifyAdmin(String username, String password,String usernameold) {
		
		String str = username+password;
		try {
			password = Md5Encoder.EncoderByMd5(str);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int flag = modifyAdminDao.modify(username, password, usernameold);
		if(flag==0){
			return -1;//更新失败
		}
		return 0;
	}

}
