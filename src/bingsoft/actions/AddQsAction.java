package bingsoft.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import service.ProQs;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 添加专业单选题
 * @author Administrator
 *
 */
@Scope("prototype")
@Controller("AddQs")
public class AddQsAction extends ActionSupport {
	
	private static final long serialVersionUID = 6496163297503830657L;
	@Resource(name="proQsImpl")
	private ProQs pq;
	private String course="";
	private String question_type="";
	private String sTitle="";
	private String sOptionA="";
	private String sOptionB="";
	private String sOptionC="";
	private String sOptionD="";
	private String single_right="";
	private String eTitle="";
	private String eRight="";
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
	
	

	

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsOptionA() {
		return sOptionA;
	}

	public void setsOptionA(String sOptionA) {
		this.sOptionA = sOptionA;
	}

	public String getsOptionB() {
		return sOptionB;
	}

	public void setsOptionB(String sOptionB) {
		this.sOptionB = sOptionB;
	}

	public String getsOptionC() {
		return sOptionC;
	}

	public void setsOptionC(String sOptionC) {
		this.sOptionC = sOptionC;
	}

	public String getsOptionD() {
		return sOptionD;
	}

	public void setsOptionD(String sOptionD) {
		this.sOptionD = sOptionD;
	}
	public String getSingle_right() {
		return single_right;
	}

	public void setSingle_right(String single_right) {
		this.single_right = single_right;
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	public String geteRight() {
		return eRight;
	}

	public void seteRight(String eRight) {
		this.eRight = eRight;
	}
	public String execute(){
		System.out.println("进入添加专业单选(AddQsAction)");
		/*ActionContext ctx = ActionContext.getContext();*/
		try{
		int flag = pq.addProQs(getCourse(), getQuestion_type(), getsTitle(), getsOptionA(), getsOptionB(), getsOptionC(), getsOptionD(), getSingle_right(), geteTitle(), geteRight()); ;
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
		/*ctx.put("tip", "完成");*/
		try {
			inputStram = new ByteArrayInputStream("success".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		}
		return SUCCESS;		
	}
}
