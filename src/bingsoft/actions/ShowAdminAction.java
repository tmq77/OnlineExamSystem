package bingsoft.actions;

import java.util.ArrayList;

import javax.annotation.Resource;

import model.AdminUser;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ShowAdmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("ShowAdmin")
public class ShowAdminAction extends ActionSupport{

	private static final long serialVersionUID = 938593728613699530L;
	
	@Resource(name="showAdminImpl")
	private ShowAdmin showAdmin;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		ArrayList<AdminUser> admin = showAdmin.show();
		ctx.put("admin", admin);
		return SUCCESS;
	}

}
