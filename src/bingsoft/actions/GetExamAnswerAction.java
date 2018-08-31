package bingsoft.actions;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import service.HandleBaseAnswer;
import service.InsertExamAnswer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 存储试卷答案
 * @author taominqi
 *
 */
@Controller("GetExamAnswer")
@Scope("prototype")
public class GetExamAnswerAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 6345908110192307284L;

	
	
	@Resource(name="handleBaseAnswerImpl")
	private HandleBaseAnswer handleBaseAnswer;   //单选自动评分
	
	@Resource(name="insertExamAnswerImpl")
	private InsertExamAnswer insertExamAnswer; //存储答案的服务层
	
	private String baseid1;
	private String baseid2;
	private String baseid3;
	private String baseans1;
	private String baseans2;
	private String baseans3;
	private String proid1;
	private String proid2;
	private String proid3;
	private String proans1;
	private String proans2;
	private String proans3;
	private String voiceanswer;
	private String reanswer;
	private String rid;
	private String result;
	public String getBaseid1() {
		return baseid1;
	}
	public void setBaseid1(String baseid1) {
		this.baseid1 = baseid1;
	}
	public String getBaseid2() {
		return baseid2;
	}
	public void setBaseid2(String baseid2) {
		this.baseid2 = baseid2;
	}
	public String getBaseid3() {
		return baseid3;
	}
	public void setBaseid3(String baseid3) {
		this.baseid3 = baseid3;
	}
	public String getProid1() {
		return proid1;
	}
	public void setProid1(String proid1) {
		this.proid1 = proid1;
	}
	public String getProid2() {
		return proid2;
	}
	public void setProid2(String proid2) {
		this.proid2 = proid2;
	}
	public String getProid3() {
		return proid3;
	}
	public void setProid3(String proid3) {
		this.proid3 = proid3;
	}
	public String getVoiceanswer() {
		return voiceanswer;
	}
	public void setVoiceanswer(String voiceanswer) {
		this.voiceanswer = voiceanswer;
	}
	public String getReanswer() {
		return reanswer;
	}
	public void setReanswer(String reanswer) {
		this.reanswer = reanswer;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
	public String getBaseans1() {
		return baseans1;
	}
	public void setBaseans1(String baseans1) {
		this.baseans1 = baseans1;
	}
	public String getBaseans2() {
		return baseans2;
	}
	public void setBaseans2(String baseans2) {
		this.baseans2 = baseans2;
	}
	public String getBaseans3() {
		return baseans3;
	}
	public void setBaseans3(String baseans3) {
		this.baseans3 = baseans3;
	}
	public String getProans1() {
		return proans1;
	}
	public void setProans1(String proans1) {
		this.proans1 = proans1;
	}
	public String getProans2() {
		return proans2;
	}
	public void setProans2(String proans2) {
		this.proans2 = proans2;
	}
	public String getProans3() {
		return proans3;
	}
	public void setProans3(String proans3) {
		this.proans3 = proans3;
	}
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	
	@SuppressWarnings("unchecked")
	public String execute(){
		ActionContext ctx =ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		ArrayList<String> referenceAnswer = new ArrayList<String>(); //r..Answer---正确答案
		referenceAnswer=(ArrayList<String>) session.get("answer");    //取出正确答案
		ArrayList<Integer> singleID = (ArrayList<Integer>) session.get("singleID"); //取出试题序号
		String[] temp = getResult().split(","); //将考生答案取出
		String username=(String)ctx.getSession().get("login");
		
		
		int score = handleBaseAnswer.handleBase(referenceAnswer, temp);
		System.out.println(score+"分");
		try{
		insertExamAnswer.insertExamSafely(score, username, getProid1(), getProid2(), getProid3(), getProans1(), getProans2(), getProans3(), getBaseid1(), getBaseid2(), getBaseid3(), getBaseans1(), getBaseans2(), getBaseans3(), getRid(), getReanswer(), getVoiceanswer(), temp, singleID);
		}catch(Exception e){
			e.printStackTrace();
			session.clear();
			return NONE;
		}
		
		return SUCCESS;
		
	}

	
	

}
