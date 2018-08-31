package service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import mapper.RootLoginDao;
import model.RootUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.Md5Encoder;
import service.RootLogin;

@Transactional
@Service("rootLoginImpl")
public class RootLoginImpl implements RootLogin{

	@Autowired
	private RootLoginDao rootLoginDao;
	
	public int loginJudge(String username, String password) {
		RootUser user = rootLoginDao.judgeRoot(username);
		String str = username+password;
		try {
			if(user==null){//不存在此用户
				return -1;
			}else if(Md5Encoder.EncoderByMd5(str).equals(user.getPassword())){
				return 1; //验证通过
			}else{
				return -2;//密码错误
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return 0; //系统异常
	}

}
