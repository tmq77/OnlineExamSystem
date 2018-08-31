package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.DeleteAdmin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 删除管理员
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("DeleteAdmin")
public class DeleteAdminAction extends ActionSupport{

	private static final long serialVersionUID = 4002623573385038435L;
	
	@Resource(name="deleteAdminImpl")
	private DeleteAdmin deleteAdmin;
	private String username;
	private InputStream inputStream;
	
	public InputStream getResult(){
		return inputStream;
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
		try{
		int flag= deleteAdmin.deleteAdmin(getUsername());
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
