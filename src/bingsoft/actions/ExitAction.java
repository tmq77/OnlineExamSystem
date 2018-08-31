package bingsoft.actions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("Exit")
public class ExitAction extends ActionSupport{
	
	private static final long serialVersionUID = -1783121283960210755L;

	public String execute() {
		
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

}
