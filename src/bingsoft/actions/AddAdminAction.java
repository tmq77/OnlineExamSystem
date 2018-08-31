package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.AddAdmin;

import com.opensymphony.xwork2.ActionSupport;

/**录入管理员
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("AddAdmin")
public class AddAdminAction extends ActionSupport{

	private static final long serialVersionUID = 1366786288473283618L;
	
	@Resource(name="addAdminImpl")
	private AddAdmin addAdmin;
	private String username;
	private String password;
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
		try{
		int flag = addAdmin.insertAdmin(getUsername(), getPassword());
		
		if(flag==-1){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return ERROR;
		}
		
		}catch(Exception e)	{
			try {
				inputStream = new ByteArrayInputStream("none".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) {
				ee.printStackTrace();
			}
			return NONE;
		}
		
		
		/*try {
			inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return SUCCESS;
	}

}
