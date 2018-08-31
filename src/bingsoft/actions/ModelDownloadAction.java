package bingsoft.actions;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ModelDownload")
public class ModelDownloadAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 3691130872299356038L;
	private String filename;
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	/*
	定义一个返回InputStream的方法，
	该方法将作为被下载文件的入口，
	且需要在配置stream类型结果时指定inputName参数，
	inputName参数的值就是方法去掉get前缀、首字母小写的字符串---即为本方法去掉。。。。。
	*/
	public InputStream getTargetFile() throws Exception
	{
		// ServletContext提供getResourceAsStream()方法
		// 返回指定文件对应的输入流
		
		return ServletActionContext.getServletContext()
			.getResourceAsStream("/model.xls");
	}
	
	
	

}
