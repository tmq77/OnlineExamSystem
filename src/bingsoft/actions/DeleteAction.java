package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.Delete;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Controller("Delete")
public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = -4879396024708603260L;
	@Resource(name = "deleteImpl")
	private Delete dt;
	private String username = ""; // 前端传来的name属性
	private String judge=""; //确定是judge页面调用这个action
	private InputStream inputStram;
	public InputStream getInputStram() {
		return inputStram;
	}
	public void setInputStram(InputStream inputStram) {
		this.inputStram = inputStram;
	}
	
	public InputStream getResult(){
		return inputStram;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String execute() {
		System.out.println("进入删除DeleteAction");
		int flag = dt.delete(getUsername());
		
		if(flag==1&&getJudge().equals("judge")){
			return NONE;
			
		}
		
		if (flag == 1) {
			return SUCCESS;
		}
		
		try {
			inputStram = new ByteArrayInputStream("error".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		}
		return ERROR;
	}
}
