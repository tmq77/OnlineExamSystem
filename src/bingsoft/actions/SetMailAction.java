package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 设置管理员邮箱账号
 * 使用cookie
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("SetMail")
public class SetMailAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 3445094016421103657L;
	private String mail;
	private String password;
	private String protocol;
	private InputStream inputStream;
	public InputStream getResult(){
		return inputStream;
	}
	public String getMail() {
		return mail;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String execute(){
		
		if(!checkEmail(getMail())){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ERROR;
		}
		
		//获取response对象,cookie必须由response添加
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie account = new Cookie("examAccount",getMail());
		Cookie pass = new Cookie("examPassword",getPassword());
		Cookie protocol = new Cookie("examProtocal", getProtocol());
		//设置cookie有效期为一个月
		account.setMaxAge(30*24*3600);
		pass.setMaxAge(30*24*3600);
		protocol.setMaxAge(30*24*3600);
		response.addCookie(account);
		response.addCookie(pass);
		response.addCookie(protocol);
		
		try {
			inputStream = new ByteArrayInputStream("success".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	
	//邮箱验证
	 public  boolean checkEmail(String email){
	        boolean flag = false;
	        try{
	                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	                Pattern regex = Pattern.compile(check);
	                Matcher matcher = regex.matcher(email);
	                flag = matcher.matches();
	            }catch(Exception e){
	                flag = false;
	            }
	        return flag;
	    }
	
	

}
