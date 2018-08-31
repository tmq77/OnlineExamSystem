package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.RootLogin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("RootLogin")
public class RootLoginAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -8828312282781634310L;
	
	@Resource(name="rootLoginImpl")
	private RootLogin rootLogin;
	private String username;
	private String password;
	private InputStream inputStream;
	
	public InputStream getResult(){
		return inputStream;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String execute(){
		
		int flag = rootLogin.loginJudge(getUsername(), getPassword());

		if(flag==0){//系统异常
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return ERROR;
		}
		
		if(flag==-2){
			try {//密码错误
				inputStream = new ByteArrayInputStream("input".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return INPUT;
		}
		
		if(flag==-1){
			try {//查无此人
				inputStream = new ByteArrayInputStream("none".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return NONE;
		}
		
		ActionContext.getContext().getSession().put("login", getUsername());
		return SUCCESS;
	}
	
}
