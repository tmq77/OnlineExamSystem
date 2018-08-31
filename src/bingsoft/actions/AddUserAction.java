package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.AddUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("AddUser")
public class AddUserAction extends ActionSupport{

	private static final long serialVersionUID = -6098446779062053673L;
	
	
	@Resource(name="addUserImpl")
	private AddUser au;
	private String username="";
	private String name="";
	private String post="";
	private String mail="";
	private InputStream inputStream;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	
	/**
	 * 自动获取手机号后六位作为密码
	 * @return 手机号后六位
	 */
	public String getPassword(){
		
		return this.getUsername().substring(5);
	
	}
	

	
	public String execute(){
		System.out.println("进入添加人员信息(AddUserAction)");
		
		if(getUsername().length()!=11||!isMobileNO(getUsername())){
			try {
				inputStream = new ByteArrayInputStream("phone".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) { 
				e.printStackTrace();
			}
			return NONE;
			
		}
		if(getMail()==null||getMail().equals("")){
			//为空不做处理
			System.out.println("未输入邮箱");
		}else{//判断邮箱
			if(!checkEmail(getMail())){
				try {
					inputStream = new ByteArrayInputStream("mail".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) { 
					e.printStackTrace();
				}
				return NONE;
			}
		}
		
		ActionContext ctx = ActionContext.getContext();
		if("disabled".equals(getPost())){
			/*ctx.put("tip","请选择职位");*/
			try {
				inputStream = new ByteArrayInputStream("select".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) { 
				e.printStackTrace();
			}
			return INPUT;
		}
		
		int i=au.addInterviewer(getName(), getUsername(), getPassword(), getPost(),getMail());
		if(i==-1){//主键重复异常
			/*ctx.put("tip","人员重复！");*/
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) { 
				e.printStackTrace();
			}
			return ERROR;
		}
		ctx.put("tip","录入成功！");
		return SUCCESS;
	}
	
	//号码匹配
	public boolean isMobileNO(String mobiles){  
		
		/*Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  */
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,1,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
		Matcher m = p.matcher(mobiles);  
		  
		/*System.out.println(m.matches()+"号码匹配");  */
		  
		return m.matches();
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
	
	
	/*public void validate(){

		if(getUsername().length()!=11||!isMobileNO(getUsername())){

			addFieldError("tip","请输入正确的手机号");
		}
	}*/
	
	
	

}
