package bingsoft.actions;

import javax.annotation.Resource;

import model.UpdateUserTemp;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.UpdateTemp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Controller("UpdateTemp")
public class UpdateTempAction extends ActionSupport{

	
	private static final long serialVersionUID = -6849883220033721130L;
	@Resource(name="updateTempImpl")
	private UpdateTemp ut;
	private String username="";
	private UpdateUserTemp jsonList;
	@JSON(name="json")
	public UpdateUserTemp getJsonList() {
		return jsonList;
	}

	public void setJsonList(UpdateUserTemp jsonList) {
		this.jsonList = jsonList;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String execute(){
		ActionContext ctx =ActionContext.getContext();
		UpdateUserTemp utd= ut.temp(getUsername());
				/*ctx.put("post", utd.getPost());
				ctx.put("name", utd.getName());
				ctx.put("username", utd.getAccount());
				ctx.put("mail", utd.getEmail());*/
		jsonList = utd;
				ctx.getSession().put("temp", utd.getUid());
		return SUCCESS;
		
	}

}
