package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ParseXls;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ParseXls")
public class ParseXlsAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 1932333238172939040L;

	
	private ArrayList<String> jsonList;
	private String name;
	
	@Resource(name="parseXlsImpl")
	private ParseXls parseXls;
	
	private String savePath;  //配置文件中配置
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

	@JSON(name="json")
	public ArrayList<String> getJsonList() {
		return jsonList;
	}

	public void setJsonList(ArrayList<String> jsonList) {
		this.jsonList = jsonList;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute(){
		ArrayList<String> info = parseXls.parse(getName(),getSavePath()+"/"+getName());
		
		if(info==null){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return ERROR; //格式不对或者文件没有找到
		}
		jsonList  = info;
		jsonList.add(0, "success");
		return SUCCESS;
		
	}

}
