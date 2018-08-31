package bingsoft.actions;

import java.io.InputStream;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.ModifyStatusService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取到人员信息后的二次精确信息确认
 * @author taominqi
 *
 */
@Scope("prototype")
@Controller("ModifyStatus")
public class ModifyStatusAction extends ActionSupport{

	
	private static final long serialVersionUID = 4124019086202434700L;
	
	@Resource(name="modifyStatusImpl")
	ModifyStatusService modify;
	private InputStream inputStram;
	private ArrayList<String> jsonList;
	@JSON(name="json")
	public ArrayList<String> getJsonList() {
		return jsonList;
	}

	public void setJsonList(ArrayList<String> jsonList) {
		this.jsonList = jsonList;
	}
	
	private int pageNo=1;
	
	public InputStream getInputStram() {
		return inputStram;
	}
	public void setInputStram(InputStream inputStram) {
		this.inputStram = inputStram;
	}
	
	public InputStream getResult(){
		return inputStram;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String execute(){
		
		int pageSize = modify.totalPage();
		int index = 0;
		int page = getPageNo();
		if(page<=0){
			page=pageSize;
		}else if(page>pageSize){
			page=1;
		}
		index = 6*(page-1);
		ArrayList<String> userList = modify.modifyData(index);
		jsonList = userList; //使用struts2自带的json支持插件
		
		/*JSONArray jsonArray = JSONArray.fromObject(userList);
		
		try {
			inputStram = new ByteArrayInputStream(jsonArray.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		
		return SUCCESS;
		
	}
}
