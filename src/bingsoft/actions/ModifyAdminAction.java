package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ModifyAdmin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 修改管理员信息
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("ModifyAdmin")
public class ModifyAdminAction extends ActionSupport{

	
	private static final long serialVersionUID = -1750990368127889399L;
	
	@Resource(name="modifyAdminImpl")
	private ModifyAdmin modifyAdmin;
	private String username;
	private String password;
	private String usernameold;
	private InputStream inputStream;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsernameold() {
		return usernameold;
	}
	public void setUsernameold(String usernameold) {
		this.usernameold = usernameold;
	}
	
	public String execute(){
		try{
		int flag = modifyAdmin.modifyAdmin(getUsername(), getPassword(), getUsernameold());
		if(flag==-1){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return ERROR;
		}
		}catch(Exception ee){
			try {
				inputStream = new ByteArrayInputStream("none".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return NONE;
		}
		return SUCCESS;
	}
	
}
