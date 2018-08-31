package service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import mapper.LoginDao;
import model.AdminUser;
import model.InterUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.Md5Encoder;
import service.Login;

/**
 * 判断身份进行登录
 * @author Administrator
 *
 */
@Transactional
@Service("roleJudge")
public class RoleJudge implements Login{

	@Autowired
	private LoginDao loginDao;
	
	/**
	 * @return -1   考生没有考试资格<br>
	 * 1   考生密码正确<br>
	 * 0  考生密码错误<br>
	 *-2 不是管理员<br>
	 * 2   管理员密码正确<br>  
	 * 3  管理员密码错误<br>
	 * 4  没有选择身份
	 * 5 已考试
	 */
	
	public int judge(String role,String username, String password) {
		
		if(role.equals("employee")){
			InterUser interUser = loginDao.findInterUser(username);
			
			
			
				if (interUser==null) { 
					return -1;  
				} else if(interUser.getStatus().equals("t")){
					return 5;
				}else if (interUser.getPass().equals(password)){
					return 1;   
					} else { 
						return 0; 
					}
		}
		else if (role.equals("admin")) { 
			AdminUser adminUser = loginDao.findAdminUser(username);
			String str = username+password; //盐值加密
			try {
				String key = Md5Encoder.EncoderByMd5(str);
				if (adminUser==null) {
					return -2;
				} else if (adminUser.getPass().equals(key)){
						return 2;
					} else { 
						return 3;
					}
				
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		return 4; 
		
	}

}
