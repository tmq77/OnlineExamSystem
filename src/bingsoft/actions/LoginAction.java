package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.Login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 执行登录处理的Action
 * 
 * @author taomi_000
 *
 */

@Scope("prototype")
@Controller("Login")
public class LoginAction extends ActionSupport {
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的<br>
	 * 下面的ID是由该类各个属性生成的哈希字段
	 */
	private static final long serialVersionUID = 6696371331642731846L;
 
	private Login lg;
	private String username = "";
	private String password = "";
	private String role = "";
	private InputStream inputStream;
	
	
	@Resource(name="roleJudge")
	public void setLg(Login lg){
		this.lg=lg;
	}
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public String execute() throws UnsupportedEncodingException {
		ActionContext ctx = ActionContext.getContext(); 
		int judge=lg.judge(getRole(), getUsername(), getPassword());
		
		switch (judge) {
		case -1:
			//ctx.put("tip", "您未取得考试资格~");
			//return ERROR;
			inputStream = new ByteArrayInputStream("noaccess".getBytes("UTF-8"));
			return NONE;
		case 1:
			ctx.getSession().put("login", getUsername());
			return SUCCESS;
		case 0:
			//ctx.put("tip", "密码不正确");
			inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			//return ERROR;
			return NONE;
		case -2:
			//ctx.put("tip", "您不是管理员~");
			inputStream = new ByteArrayInputStream("notadmin".getBytes("UTF-8"));
			return NONE;
		case 2:
			ctx.getSession().put("login", getUsername());
			return INPUT;
		case 3:
			//ctx.put("tip", "管理员密码不正确");
			inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			return NONE;
		case 5:
			//ctx.put("tip", "请勿重复考试");
			inputStream = new ByteArrayInputStream("wrong".getBytes("UTF-8"));
			return NONE;
			//return ERROR;
		default:
			System.out.println(judge);	//------测试代码
			System.out.println("没有选择身份的情况");   //------测试代码
			
//			ctx.put("tip", "请选择身份~");
			return ERROR;
		}	
	}

}
