package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import service.Delete;
import service.GetStaff;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 插入通过人员信息
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("GetStaff")
public class GetStaffAction extends ActionSupport{
	
	private static final long serialVersionUID = -4585642230540569060L;
	private String username;
	private String name;
	private String post;
	private String mail;
	private InputStream inputStream;
	
	@Resource(name="getStaffImpl")
	private GetStaff getStaff;
	
	@Resource(name = "deleteImpl")
	private Delete delete;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String execute(){
		try{
		int flag=getStaff.getStaff(getUsername(), getName(), getPost(),getMail()); //执行插入数据库操作
		if(flag==-1){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) { 
				ee.printStackTrace();
			}
			return ERROR;
		}
		}catch(DataAccessException e){
			//违背唯一性约束的情况，不执行插入
			try {
				inputStream = new ByteArrayInputStream("none".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) { 
				ee.printStackTrace();
			}
			return NONE;
		}
		delete.delete(getUsername());//将通过的人员存入面试表后,执行人员信息表的删除
		return SUCCESS;
	}
	

}
