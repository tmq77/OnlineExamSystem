package model;

/**
 * 数据类
 * 专业简答插入数据库
 * @author taominqi
 *
 */
public class InsertProAnswer {
	
	private String proId;
	private String account;
	private String essayId;
	private String answer;
	public InsertProAnswer() {
		// TODO Auto-generated constructor stub
	}
	public InsertProAnswer(String proId,String account, String essayId, String answer) {
		super();
		this.setProId(proId);
		this.account = account;
		this.essayId = essayId;
		this.answer = answer;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEssayId() {
		return essayId;
	}
	public void setEssayId(String essayId) {
		this.essayId = essayId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	

}
