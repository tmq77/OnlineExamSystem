package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.DeleteRequiredQs;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 删除综合题
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("DeleteRequiredQs")
public class DeleteRequiredQsAction extends ActionSupport{

	
	private static final long serialVersionUID = 3236070390101715723L;
	@Resource(name="deleteRequiredQsImpl")
	private DeleteRequiredQs deleteRequiredQs;
	private InputStream inputStream;
	private int rid;
	private String post;
	public InputStream getResult(){
		return inputStream;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String execute(){
		try{
		int flag = deleteRequiredQs.deleteRequired(getRid());
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
		ActionContext.getContext().put("post", getPost());
		return SUCCESS;
	}
}
