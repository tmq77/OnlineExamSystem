package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import service.DeleteProEssay;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 删除专业简答题
 * @author taominqi
 *
 */
@Scope("prototype")
@Service("DeleteProEssay")
public class DeleteProEssayAction extends ActionSupport{
	
	
	
	private static final long serialVersionUID = -2995737872513090666L;
	@Resource(name="deleteProEssayImpl")
	private DeleteProEssay deleteProEssay;
	private InputStream inputStream;
	private int essayId;
	private String post;
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
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
		int flag = deleteProEssay.deletePro(getEssayId());
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
