package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import model.BaseQs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ModifySingle;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ModifySingle")
public class ModifySingleAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 8263129737171842203L;
	@Resource(name="modifySingleImpl")
	private ModifySingle modifySingle;
	private int eid;
	private String title;
	private String singleA;
	private String singleB;
	private String singleC;
	private String singleD;
	private String singleAs;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSingleA() {
		return singleA;
	}
	public void setSingleA(String singleA) {
		this.singleA = singleA;
	}
	public String getSingleB() {
		return singleB;
	}
	public void setSingleB(String singleB) {
		this.singleB = singleB;
	}
	public String getSingleC() {
		return singleC;
	}
	public void setSingleC(String singleC) {
		this.singleC = singleC;
	}
	public String getSingleD() {
		return singleD;
	}
	public void setSingleD(String singleD) {
		this.singleD = singleD;
	}
	public String getSingleAs() {
		return singleAs;
	}
	public void setSingleAs(String singleAs) {
		this.singleAs = singleAs;
	}

	private InputStream inputStream;
	
	public InputStream getResult(){
		return inputStream;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String execute(){
		BaseQs baseQs = new BaseQs(getTitle(), getSingleA(), getSingleB(), getSingleC(), getSingleD(), getSingleAs(), getEid());
		try{
		int flag = modifySingle.modifySingle(baseQs);
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
