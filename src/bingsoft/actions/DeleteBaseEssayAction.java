package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import service.DeleteBaseEssay;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Service("DeleteBaseEssay")
public class DeleteBaseEssayAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -3032056263749188025L;
	@Resource(name="deleteBaseEssayImpl")
	private DeleteBaseEssay deleteBaseEssay;
	private InputStream inputStream;
	private int essayId;
	
	public InputStream getResult(){
		return inputStream;
	}
	public int getEssayId() {
		return essayId;
	}
	public void setEssayId(int essayId) {
		this.essayId = essayId;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String execute(){
		try{
		int flag = deleteBaseEssay.deleteBase(getEssayId());
		if(flag==0){
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
		return SUCCESS;
	}
}
