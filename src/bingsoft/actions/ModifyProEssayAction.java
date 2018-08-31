package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ModifyProEssay;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 修改专业题
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("ModifyProEssay")
public class ModifyProEssayAction extends ActionSupport{

	

	private static final long serialVersionUID = -1337959261959348169L;
	private InputStream inputStream;
	private String essayTitle;
	private String essayRight;
	private String post;
	private int essayId;
	
	@Resource(name="modifyProEssayImpl")
	private ModifyProEssay modifyProEssay;
	
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
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String execute(){
		try{
		int flag = modifyProEssay.modifyPro(getEssayTitle(), getEssayRight(), getEssayId(),getPost());
		if(flag!=0){
			ActionContext.getContext().put("post", getPost());
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
