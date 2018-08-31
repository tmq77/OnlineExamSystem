package service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import mapper.AddAdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.Md5Encoder;
import service.AddAdmin;

@Transactional
@Service("addAdminImpl")
public class AddAdminImpl implements AddAdmin{

	@Autowired
	private AddAdminDao addAdminDao;
	
	public int insertAdmin(String username, String password) {
		
		String str = username+password;
		
		try {
			password = Md5Encoder.EncoderByMd5(str);  //md5加密
			int flag = addAdminDao.addAdmin(username, password);
			if(flag==0){
				return -1; //录入失败
			}
			
		} catch ( NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}

}
