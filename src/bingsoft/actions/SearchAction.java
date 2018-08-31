package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.annotation.Resource;

import model.BaseEssay;
import model.ModifyRequiredQs;
import model.ProEssay;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.Search;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("Search")
public class SearchAction extends ActionSupport{


	private static final long serialVersionUID = 6287691239995643102L;
	public static final String SINGLE = "single";
	public static final String BASESINGLE = "baseEssay";
	public static final String CHOICE = "choice";
	public static final String REQUIRED = "required";
	private InputStream inputStream;
	private String type; //搜索的试题类型
	private String str;//输入的搜索内容
	private String post;
	
	@Resource(name="searchImpl")
	private Search search;
	
	public InputStream getResult(){
		return inputStream;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getStr() {
		return str;
	}
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		
		if(getStr()==null||getStr().equals("")){
			try {
				inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return ERROR;
		}
		
		if("single".equals(getType())){
			
			ArrayList<model.BaseQs> baseQs = search.getSingleSearch("%"+getStr()+"%");
			if(baseQs.size()==0){
				try {
					inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return NONE;
			}
			ctx.put("single", baseQs);
			return SINGLE;
		}else if("baseEssay".equals(getType())){
			ArrayList<BaseEssay> baseEssay = search.getBaseEssaySearch("%"+getStr()+"%");
			if(baseEssay.size()==0){
				try {
					inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return NONE;
			}
			ctx.put("baseEssay", baseEssay);
			return BASESINGLE;
		}else if("choice".equals(getType())){
			ArrayList<ProEssay> proEssay = search.getProEssaySearch(getPost(), "%"+getStr()+"%");
			if(proEssay.size()==0){
				try {
					inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return NONE;
			}
			ctx.put("proEssay", proEssay);
			return CHOICE;
		}else if("required".equals(getType())){
			ArrayList<ModifyRequiredQs> required = search.getRequiredQsSearch(getPost(),  "%"+getStr()+"%");
			if(required.size()==0){
				try {
					inputStream = new ByteArrayInputStream("none".getBytes("utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return NONE;
			}
			ctx.put("required", required);
			return REQUIRED;
		}
		try {
			inputStream = new ByteArrayInputStream("error".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}
