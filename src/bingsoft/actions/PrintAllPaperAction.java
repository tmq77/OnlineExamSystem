package bingsoft.actions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import model.GetAnswerData;
import model.GetRequiredAnswer;
import model.PaperBaseQs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.PrintAllPaper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 打印试卷前取出数据
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("PrintAllPaper")
public class PrintAllPaperAction extends ActionSupport{

	
	private static final long serialVersionUID = -6378408276116364713L;
	private String username;
	private String name;
	private InputStream inputStream;
	
	@Resource(name="printAllPaperImpl")
	private PrintAllPaper printAllPaper;
	
	public InputStream getResult(){
		return inputStream;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	@SuppressWarnings("unchecked")
	public String execute(){
		Map<String,Object> map= printAllPaper.printExamPaper(getUsername());
		ActionContext ctx = ActionContext.getContext();
		ArrayList<PaperBaseQs> singleQs = (ArrayList<PaperBaseQs>) map.get("singleQs"); //存放单选
		ArrayList<GetAnswerData> proExam =(ArrayList<GetAnswerData>) map.get("proExam");//存放专业简答
		ArrayList<GetAnswerData > baseExam = (ArrayList<GetAnswerData>) map.get("baseExam");//存放基础简答
		GetRequiredAnswer requiredExam = (GetRequiredAnswer) map.get("requiredExam");//综合题
		ctx.put("singleQs", singleQs);
		ctx.put("proExam", proExam);
		ctx.put("baseExam", baseExam);
		ctx.put("requiredExam", requiredExam);
		ctx.put("name", getName());
		return SUCCESS;
	}
	
}
