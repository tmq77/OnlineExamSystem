package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.SingleUpload;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("SingleUpload")
public class SingleUploadAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 8113983499936619741L;
	private File file;   //上传的文件
	private String fileContentType; //文件类型
	private String fileFileName;
	private InputStream inputStream;

	@Resource(name="singleUploadImpl")
	private SingleUpload singleUpload;

	
	private String savePath;  //配置文件中配置


	public InputStream getResult(){
		return inputStream;
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String execute(){
		String flag = singleUpload.upload(getFile(), getSavePath(), getFileFileName());
		if(flag.equals("error")){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			return ERROR;
		}
		try {
			inputStream = new ByteArrayInputStream(("suc"+flag).getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	

}
