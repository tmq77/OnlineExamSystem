package service;

public interface SendEmail {
	
	int sendMail(String name,String email,String post,String time,String adminMail,String adminPass,String protocal) throws Exception;

}
