package bingsoft.actions;

import javax.annotation.Resource;

import model.GetRequiredAnswer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ShowRequiredAnswer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ShowRequiredAnswer")
public class ShowRequiredAnswerAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -8829540714452390028L;

	@Resource(name="showRequiredAnswerImpl")
	private ShowRequiredAnswer showRequiredAnswer;
	
	private String account;
	
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		
		GetRequiredAnswer answer =showRequiredAnswer.showRequiredAnswer(getAccount());
		ctx.put("ga",answer);
		return SUCCESS;
		
	}

}
