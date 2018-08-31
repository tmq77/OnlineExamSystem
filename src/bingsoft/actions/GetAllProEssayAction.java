package bingsoft.actions;

import java.util.ArrayList;

import javax.annotation.Resource;

import model.ProEssay;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.GetAllProEssay;
import Handler.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取专业简答题的题目
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("GetAllProEssay")
public class GetAllProEssayAction extends ActionSupport{

	private static final long serialVersionUID = 6233357017441830447L;
	private String post;
	private String pageNo;
	@Resource(name="getAllProEssayImpl")
	private GetAllProEssay getAllProEssay;

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	public String execute(){
		
		int pageSize = PageUtil.getTotalPage(4, getAllProEssay.getCounts(getPost()));
		int page = PageUtil.getCurrentPageNo(getPageNo(), pageSize);
		int index = PageUtil.getIndex(page, 4);
		
		ArrayList<ProEssay> proEssay = getAllProEssay.getAllPro(post, index);
		
		ActionContext ctx = ActionContext.getContext();
		ctx.put("page", page);
		ctx.put("pageSize", pageSize);
		ctx.put("proEssay",proEssay);
		
		return SUCCESS;
	}
	
	
}
