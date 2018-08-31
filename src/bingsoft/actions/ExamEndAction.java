package bingsoft.actions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 考试结束，将单选分数存入数据库的Action
 * @author Administrator
 *
 */
@Scope("prototype")
@Controller("ExamEnd")
public class ExamEndAction extends ActionSupport{
	

	private static final long serialVersionUID = -3366365114007904215L;


	public String execute(){
		System.out.println("进入最后处理阶段(ExamEndAction)。。。");
		
		ActionContext.getContext().getSession().clear(); //清除登录信息,防止考生直接通过url输入admin进入后台
		return SUCCESS;
	}

}
