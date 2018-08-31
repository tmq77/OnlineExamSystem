package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ModifyBaseEssay;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ModifyBaseEssay")
public class ModifyBaseEssayAction extends ActionSupport{


	private static final long serialVersionUID = 2102780706769956467L;
	private InputStream inputStream;
	private String essayTitle;
	private String essayRight;
	private int essayId;
	
	@Resource(name="modifyBaseEssayImpl")
	private ModifyBaseEssay modifyBaseEssay;
	
	public InputStream getResult(){
		return inputStream;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getEssayTitle() {
		return essayTitle;
	}
	public void setEssayTitle(String essayTitle) {
		this.essayTitle = essayTitle;
	}
	public String getEssayRight() {
		return essayRight;
	}
	public void setEssayRight(String essayRight) {
		this.essayRight = essayRight;
	}
	public int getEssayId() {
		return essayId;
	}
	public void setEssayId(int essayId) {
		this.essayId = essayId;
	}
	
	public String execute(){
		try{
		int flag = modifyBaseEssay.modifyEssay(getEssayTitle(), getEssayRight(), getEssayId());
		if(flag!=0){
			return SUCCESS;
		}else{
			inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
			return NONE;
		}
		}catch(Exception e){
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			return ERROR;
		}
	}
	
	
}
