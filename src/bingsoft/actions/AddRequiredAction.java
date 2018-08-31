package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import service.AddRequiredService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 录入必答题
 * @author taominqi
 *
 */
@Controller("AddRequired")
@Scope("prototype")
public class AddRequiredAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 5932649914693807569L;
	private String allTitle;
	private String allRight;
	private String course;  //职位
	@Resource(name="addRequiredImpl")
	private AddRequiredService addRequiredService;
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
	
	public String getAllTitle() {
		return allTitle;
	}
	public void setAllTitle(String allTitle) {
		this.allTitle = allTitle;
	}
	public String getAllRight() {
		return allRight;
	}
	public void setAllRight(String allRight) {
		this.allRight = allRight;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String execute(){
		try{
		int flag=addRequiredService.AddRequired(getCourse(), getAllTitle(), getAllRight());
		if(flag==-1){
			try {//输出给ajax的信息，数据流
				inputStram = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) { 
				ee.printStackTrace();
			}
			return ERROR;
		}
		}catch(DataAccessException e){
			e.printStackTrace();
			try {
				inputStram = new ByteArrayInputStream("none".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) { 
				ee.printStackTrace();
			}
			return NONE;
		}
		
		try {
			inputStram = new ByteArrayInputStream("success".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ee) { 
			ee.printStackTrace();
		}
		return SUCCESS;
	}

}
