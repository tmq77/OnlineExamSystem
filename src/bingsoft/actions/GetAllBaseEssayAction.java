package bingsoft.actions;

import java.util.ArrayList;

import javax.annotation.Resource;

import model.BaseEssay;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.GetAllBaseEssay;
import Handler.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("GetAllBaseEssay")
public class GetAllBaseEssayAction extends ActionSupport{
	
	private static final long serialVersionUID = -856764441527999368L;
	@Resource(name="getAllBaseEssayImpl")
	private GetAllBaseEssay getAllBaseEssay;
	private String pageNo;

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String execute(){
		int pageSize= PageUtil.getTotalPage(4, getAllBaseEssay.getTotalCounts());
		int page =PageUtil.getCurrentPageNo(getPageNo(), pageSize);
		int index = PageUtil.getIndex(page, 4);
		
		ArrayList<BaseEssay> BaseEssay = getAllBaseEssay.getAllBaseEssay(index);
		ActionContext ctx = ActionContext.getContext();
		ctx.put("page", page);
		ctx.put("pageSize", pageSize);
		ctx.put("BaseEssay", BaseEssay);
		return SUCCESS;
	}
	
	

}
