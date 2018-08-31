package bingsoft.actions;

import javax.annotation.Resource;

import model.InfoConfirm;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.BeforeExam;
@Scope("prototype")
@Controller("BeforeExam")
public class BeforeExamAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 3934350004911553633L;
	@Resource(name="beforeExamImpl")
	private BeforeExam be;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		String str = (String)ctx.getSession().get("login");
		InfoConfirm bed=be.confirm(str);
		ctx.getSession().put("name", bed.getName());
		ctx.getSession().put("account", bed.getAccount());
		ctx.getSession().put("postc", bed.getPost());
		
		return SUCCESS;
	}
	

}
