package bingsoft.actions;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.GetExamQs;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 控制器，转发组成试卷的数据
 * @author taominqi
 * @time 2017年3月3日15:34:26
 */
@Controller("GetExamQs")
@Scope("prototype")
public class GetExamQsAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -6774529341958279304L;
	@Resource(name="getExamQsImpl")
	private GetExamQs getExamQs;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		String post = (String) ctx.getSession().get("postc");
		String username=(String)ctx.getSession().get("login");
		
		//从业务层取出封装的数据
		Map<String,Object> getAll = getExamQs.getAllQs(post,username);
		
		//取出所有数据并转发到前端页面组卷
		ctx.put("baseQs", getAll.get("baseQs"));
		ctx.put("baseEssay", getAll.get("baseEssay"));
		ctx.put("requiredQs", getAll.get("requiredQs"));
		ctx.put("proEssay", getAll.get("proEssay"));
		ctx.getSession().put("answer", getAll.get("corAnswer"));
		ctx.getSession().put("singleID", getAll.get("singleID")); //试题序号放入session
		
		
		return SUCCESS;
	}

}
