package bingsoft.actions;

import java.util.List;

import javax.annotation.Resource;

import model.GetAnswerData;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ShowBaseAnswer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ShowBaseAnswer")
public class ShowBaseAnswerAction extends ActionSupport{
	
	private static final long serialVersionUID = -1022851282316703643L;
	@Resource(name="showBaseAnswerImpl")
	private ShowBaseAnswer sba;
	private String account="";
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String execute(){
		System.out.println("进入查看基础简答(ShowBaseAnswerAction)");
		System.out.println(getAccount());
		ActionContext ctx = ActionContext.getContext();
		List<GetAnswerData> answer = sba.showBaseAnswer(getAccount());
		System.out.println("查看参数传递，账号："+getAccount());
		ctx.put("ga", answer);
		return SUCCESS;
	}

}
