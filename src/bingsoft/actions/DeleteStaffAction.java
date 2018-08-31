package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.DeleteStaff;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("DeleteStaff")
public class DeleteStaffAction extends ActionSupport{

	
	private static final long serialVersionUID = -3833097932923513524L;

	private String username;

	@Resource(name="deleteStaffImpl")
	private DeleteStaff deleteStaff;
	
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public InputStream getResult(){
		return inputStream;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String execute(){
		if(deleteStaff.deleteTheStaff(getUsername())==-1){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) { 
				e.printStackTrace();
			}
			return ERROR;
		}
		
		
		return SUCCESS;
	}
}
