package bingsoft.actions;

import java.util.List;

import javax.annotation.Resource;

import model.ExamData;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ShowScore;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 取出单选分数，转入前台
 * @author taomi_000
 *
 */
@Scope("prototype")
@Controller("ShowScore")
public class ShowScoreAction extends ActionSupport{
	
	private int pageNo=1;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
	private static final long serialVersionUID = 2925196701772104466L;
	@Resource(name="showScoreImpl")
	private ShowScore ss;
	
	public String execute(){
		
		ActionContext ctx = ActionContext.getContext();
		int pageSize = ss.getTotalPage();
		int index = 0;
		int page = getPageNo();
		
		if(page<=0){
			page=pageSize;
		}else if(page>pageSize){
			page=1;
		}
		
		index = 6*(page-1);	
		List<ExamData> examData = ss.showScore(index);
		
		
		ctx.put("exam", examData);
		ctx.put("page", page);
		ctx.put("pageSize", pageSize);
		return SUCCESS;
	}
	

}
