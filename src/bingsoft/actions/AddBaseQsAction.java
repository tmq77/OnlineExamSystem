package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import service.BaseQs;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 添加基础题的单选题以及简答题
 * 
 * @author taomi_000
 *
 */
@Scope("prototype")
@Controller("AddBaseQs")
public class AddBaseQsAction extends ActionSupport {
	
	private static final long serialVersionUID = -6285840207575541525L;

	@Resource(name="baseQsImpl")
	private BaseQs bq;
	
	
	private String Qs_type="";
	private String eq_Title = "";
	private String eq_Single_A = "";
	private String eq_Single_B = "";
	private String eq_Single_C = "";
	private String BaseSingleTitle="";
	private String BaseSingleA="";
	private String BaseSingleB="";
	private String BaseSingleC="";
	private String BaseSingleD="";
	private String BasesingleAS="";
	private String essayTitle="";
	private String essayRight="";
	private InputStream inputStram;
	public InputStream getInputStram() {
		return inputStram;
	}
	public void setInputStram(InputStream inputStram) {
		this.inputStram = inputStram;
	}
	
	public InputStream getResult(){
		return inputStram;
	}
	


	public String getQs_type() {
		return Qs_type;
	}

	public void setQs_type(String qs_type) {
		Qs_type = qs_type;
	}

	public String getBaseSingleTitle() {
		return BaseSingleTitle;
	}

	public void setBaseSingleTitle(String baseSingleTitle) {
		BaseSingleTitle = baseSingleTitle;
	}

	public String getBaseSingleA() {
		return BaseSingleA;
	}

	public void setBaseSingleA(String baseSingleA) {
		BaseSingleA = baseSingleA;
	}

	public String getBaseSingleB() {
		return BaseSingleB;
	}

	public void setBaseSingleB(String baseSingleB) {
		BaseSingleB = baseSingleB;
	}

	public String getBaseSingleC() {
		return BaseSingleC;
	}

	public void setBaseSingleC(String baseSingleC) {
		BaseSingleC = baseSingleC;
	}

	public String getBaseSingleD() {
		return BaseSingleD;
	}

	public void setBaseSingleD(String baseSingleD) {
		BaseSingleD = baseSingleD;
	}

	public String getBasesingleAS() {
		
		return BasesingleAS;
	}

	public void setBasesingleAS(String basesingleAS) {
		BasesingleAS = basesingleAS;
	}

	public String getEq_Title() {
		return eq_Title;
	}

	public void setEq_Title(String eq_Title) {
		this.eq_Title = eq_Title;
	}
	public String getEq_Single_A() {
		return eq_Single_A;
	}

	public void setEq_Single_A(String eq_Single_A) {
		this.eq_Single_A = eq_Single_A;
	}

	public String getEq_Single_B() {
		return eq_Single_B;
	}

	public void setEq_Single_B(String eq_Single_B) {
		this.eq_Single_B = eq_Single_B;
	}

	public String getEq_Single_C() {
		return eq_Single_C;
	}

	public void setEq_Single_C(String eq_Single_C) {
		this.eq_Single_C = eq_Single_C;
	}


	public String getEssayTitle() {
		return essayTitle;
	}

	public void setEssayTitle(String essayTitle) {
		this.essayTitle = essayTitle;
	}

	public String getEssayRight() {
		return essayRight;
	}

	public void setEssayRight(String essayRight) {
		this.essayRight = essayRight;
	}

	public String execute() {
		System.out.println("进入添加基础单选(AddBaseQsAction)");
		/*ActionContext ctx = ActionContext.getContext();*/
		try{
		int flag = bq.addBaseQs(getQs_type(), getEq_Title(), getEq_Single_A(), getEq_Single_B(), getEq_Single_C(), getBaseSingleTitle(), getBaseSingleA(), getBaseSingleB(), getBaseSingleC(), getBaseSingleD(), getBasesingleAS(), getEssayTitle(), getEssayRight());
		
		if(flag==-1){
			/*ctx.put("tip", "添加失败");*/
			try {
				inputStram = new ByteArrayInputStream("error".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) { 
				e.printStackTrace();
			}
			return ERROR;
		}
		}catch(DataAccessException e){
			System.out.println(e);
			try {
				inputStram = new ByteArrayInputStream("none".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException ee) { 
				ee.printStackTrace();
			}
			return NONE;
		}
		/*ctx.put("tip", "添加成功");*/
		try {
			inputStram = new ByteArrayInputStream("success".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		}
		return SUCCESS;
		
	
	}
}
