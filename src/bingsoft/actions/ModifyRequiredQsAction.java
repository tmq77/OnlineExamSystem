package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ModifyRequiredQs;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ModifyRequiredQs")
public class ModifyRequiredQsAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 8600998299393539672L;
	@Resource(name="modifyRequiredQsImpl")
	private ModifyRequiredQs modifyRequiredQs;
	private InputStream inputStream;
	private String title;
	private String rright;
	private String post;
	private int rid;
	public InputStream getResult(){
		return inputStream;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRright() {
		return rright;
	}
	public void setRright(String rright) {
		this.rright = rright;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public String execute(){
		try{
		int flag = modifyRequiredQs.modifyReq(getTitle(), getRright(), getRid(),getPost());
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
