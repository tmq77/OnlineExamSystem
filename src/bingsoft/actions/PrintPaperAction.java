package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import service.PrintPaper;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 点击通过按钮后的数据转储
 * @author taominqi
 *
 */
@Scope("prototype")
@Service("PrintPaper")
public class PrintPaperAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -6747325059008252067L;
	
	@Resource(name="printPaperImpl")
	private PrintPaper printPaper;
	private InputStream inputStream;
	private String username;
	
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
		//spring管理的事务 过程中出错会自动回滚，不需要在服务层捕捉异常，手动捕捉会导致取消自动回滚；
		int flag = printPaper.printQs(getUsername());
		
		if(flag==-1){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return ERROR;
		}
		
		
		try {
			inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
