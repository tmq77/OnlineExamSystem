package bingsoft.actions;

import java.util.List;

import javax.annotation.Resource;

import model.GetAnswerData;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ShowProAnswer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 后台显示简答答案的Action
 * @author Administrator
 *
 */
@Scope("prototype")
@Controller("ShowProAnswer")
public class ShowProAnswerAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 2655970265264702171L;
	@Resource(name="showProAnswerImpl")
	private ShowProAnswer spa;
	private String account="";
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String execute(){
		System.out.println("进入查看专业简答(ShowProAnswerAction)");
		ActionContext ctx = ActionContext.getContext();
		List<GetAnswerData> answer = spa.showProAnswer(getAccount());
		System.out.println("查看参数传递，账号："+getAccount());
		ctx.put("ga", answer);
		return SUCCESS;
	}

}
