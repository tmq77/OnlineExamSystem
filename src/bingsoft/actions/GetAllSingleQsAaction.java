package bingsoft.actions;

import java.util.ArrayList;

import javax.annotation.Resource;

import model.BaseQs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.GetAllSingleQs;
import Handler.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取单选题修改
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("GetAllSingleQs")
public class GetAllSingleQsAaction extends ActionSupport{


	private static final long serialVersionUID = 6225934927295523290L;
	
	@Resource(name="getAllSingleQsImpl")
	private GetAllSingleQs getAllSingleQs;
	
	private String pageNo;
	
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	public String execute(){
		int pageSize = PageUtil.getTotalPage(8, getAllSingleQs.getCounts());  //PageUtil为分页优化类
		int page = PageUtil.getCurrentPageNo(getPageNo(), pageSize);  //当前页码
		int index = PageUtil.getIndex(page, 8); //传入数据库的下标起始值
		ArrayList<BaseQs> singleQs = getAllSingleQs.getSingleQsAll(index);
	
		ActionContext ctx = ActionContext.getContext();
		ctx.put("page", page);
		ctx.put("pageSize", pageSize);
		ctx.put("singleQs", singleQs);
		return SUCCESS;
	}
}
