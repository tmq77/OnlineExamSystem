package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.DeleteSingle;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 修改试题中删除单选题
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("DeleteSingle")
public class DeleteSingleAction extends ActionSupport{

	
	private static final long serialVersionUID = 8057666420473095339L;
	@Resource(name="deleteSingleImpl")
	private DeleteSingle deleteSingle;
	private int eid;
	private InputStream inputStream;
	
	public InputStream getResult(){
		return inputStream;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String execute(){
		try{
		int flag = deleteSingle.deleteSingle(getEid());
		if(flag!=0){
		return SUCCESS;
		}else{
			inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
			return NONE;
		}
		}catch(Exception e){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			return ERROR;
		}
	}
	
	
	
}
