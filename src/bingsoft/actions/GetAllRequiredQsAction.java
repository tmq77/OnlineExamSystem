package bingsoft.actions;

import java.util.ArrayList;

import javax.annotation.Resource;

import model.ModifyRequiredQs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.GetAllRequiredQs;
import Handler.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("GetAllRequiredQs")
public class GetAllRequiredQsAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 7326001918903514641L;
	private String post;
	private String pageNo;
	@Resource(name="getAllRequiredQsImpl")
	private GetAllRequiredQs getAllRequiredQs;
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	public String execute(){
		int pageSize = PageUtil.getTotalPage(4, getAllRequiredQs.getCounts(getPost()));
		int page = PageUtil.getCurrentPageNo(getPageNo(), pageSize);
		int index = PageUtil.getIndex(page, 4);
		ArrayList<ModifyRequiredQs> requiredQs = getAllRequiredQs.getRequiredQs(getPost(), index);
		ActionContext ctx = ActionContext.getContext();
		ctx.put("page", page);
		ctx.put("pageSize", pageSize);
		ctx.put("requiredQs",requiredQs);
		
		return SUCCESS;
	}

}
