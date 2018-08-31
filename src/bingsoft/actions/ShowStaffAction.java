package bingsoft.actions;

import java.util.List;

import javax.annotation.Resource;

import model.Staff;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ShowStaff;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 查看面试人员信息
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("ShowStaff")
public class ShowStaffAction extends ActionSupport{

	
	private static final long serialVersionUID = 7817697752343210453L;

	@Resource(name="showStaffImpl")
	private ShowStaff showStaff;
	
	private int pageNo=1;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		int pageSize = showStaff.staffTotalPage();
		int index = 0;
		int page = getPageNo();
		
		if(page<=0){
			page=pageSize;
		}else if(page>pageSize){
			page=1;
		}
		
		index = 6*(page-1);	
		List<Staff> staff = showStaff.showStaff(index);
		ctx.put("staff", staff);
		ctx.put("page", page);
		ctx.put("pageSize", pageSize);
		
		return SUCCESS;
		
	}
}
