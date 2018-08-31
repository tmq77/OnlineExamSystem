package service.impl;

import org.springframework.stereotype.Service;

import Handler.MailTools;
import service.SendEmail;

@Service("sendEmailImpl")
public class SendEmailImpl implements SendEmail{

	@Override
	public int sendMail(String name, String email, String post,String time,String adminMail,String adminPass,String protocol) throws Exception{
		
		MailTools.sendRegisterMail(email, name, post,time,adminMail,adminPass,protocol);
		return 0;

	}
}
