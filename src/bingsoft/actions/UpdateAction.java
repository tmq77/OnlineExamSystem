package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import service.Update;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 人员信息修改类
 * @author administrator
 *
 */
@Scope("prototype")
@Controller("Update")
public class UpdateAction extends ActionSupport{
	private static final long serialVersionUID = -5073413987717109790L;

	@Resource(name="updateImpl")
	private Update ud;
	
	private String username="";
	@SuppressWarnings("unused")
	private String password="";
	private String name="";
	private String post="";
	private String mail="";
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	
		ActionContext ctx = ActionContext.getContext();
		
		if(!isMobileNO(getUsername())){
			try {
				inputStram = new ByteArrayInputStream("phone".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) { 
				ee.printStackTrace();
			}
			return INPUT;
		}
		if(getMail()==null||getMail().equals("")){
			
		}else{
			if(!checkEmail(getMail())){
				try {
					inputStram = new ByteArrayInputStream("mail".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException ee) { 
					ee.printStackTrace();
				}
				return INPUT;
			}
		}
		
		
		try{
		ud.update(getName(), getUsername(), getPassword(), getPost(),(String)ctx.getSession().get("temp"),getMail());
		return SUCCESS;
		}catch(DataAccessException e){//主键重复异常
			System.out.println(e);
			try {
				inputStram = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) { 
				ee.printStackTrace();
			}
			return INPUT;
		}
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
	
}
