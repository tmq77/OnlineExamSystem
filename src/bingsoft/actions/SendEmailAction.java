package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.SendFailedException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.SendEmail;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("SendEmail")
public class SendEmailAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -321760686887163308L;
	@Resource(name="sendEmailImpl")
	private SendEmail sendEmail;
	private String mail;
	private String name;
	private String post;
	private String time;
	
	private InputStream inputStream;

	public InputStream getResult(){
		return inputStream;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String execute(){
	
		try{
			String mailaccount="";
			String mailpassword="";
			String protocol="";
			HttpServletRequest request = ServletActionContext.getRequest();
			Cookie[] cookies = request.getCookies();
			for(Cookie c:cookies){
				if(c.getName().equals("examAccount")){
					 mailaccount=c.getValue();
				}
				if(c.getName().equals("examPassword")){
					mailpassword = c.getValue();
				}
				if(c.getName().equals("examProtocal")){
					 protocol = c.getValue();
				}
			}
			if(mailaccount.equals("")){
				try {
					inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
				} catch (UnsupportedEncodingException ee) {
					ee.printStackTrace();
				}
				return ERROR;
			}
			if(mailpassword.equals("")){
				try {
					inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
				} catch (UnsupportedEncodingException ee) {
					ee.printStackTrace();
				}
				return ERROR;
			}
			if(protocol.equals("")){
				try {
					inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
				} catch (UnsupportedEncodingException ee) {
					ee.printStackTrace();
				}
				return ERROR;
			}
			
		 sendEmail.sendMail(getName(), getMail(), getPost(),getTime(),mailaccount,mailpassword,protocol);

	}catch(SendFailedException e){
		try {
			inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));  //发送失败
		} catch (UnsupportedEncodingException ee) {
			ee.printStackTrace();
		}
		return ERROR;
	}catch (Exception e) {
		try {
			inputStream = new ByteArrayInputStream("unhandle".getBytes("utf-8"));  //账号密码错误
		} catch (UnsupportedEncodingException ee) {
			ee.printStackTrace();
		}
		return ERROR;
	}
		
		try {
			inputStream = new ByteArrayInputStream("success".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
