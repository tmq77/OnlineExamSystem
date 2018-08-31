package bingsoft.actions;

import java.util.ArrayList;
import javax.annotation.Resource;

import model.OverViewUser;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.OverView;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 查看人员信息的Action
 * @author Administrator
 *
 */
@Scope("prototype")
@Controller("OverView")
public class OverViewAction extends ActionSupport {

	private static final long serialVersionUID = -3476511052531361147L;
	
	private int pageNo=1; //分页的初始页码

	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	


	@Resource(name="overViewImpl")
	private OverView ov;

	public String execute() {
		ActionContext ctx = ActionContext.getContext(); 
		int pageSize = ov.totalPage();
		int index = 0;
		int page = getPageNo();
		
		if(page<=0){
			page=pageSize;
		}else if(page>pageSize){
			page=1;
		}
		
		index = 6*(page-1);
		ArrayList<OverViewUser> dataInfo = (ArrayList<OverViewUser>) ov.OverData(index);

		ctx.put("info", dataInfo);   
		ctx.put("page", page);
		ctx.put("pageSize", pageSize);
		return SUCCESS;
	}

}
