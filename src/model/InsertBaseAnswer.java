package model;

/**
 * 基础简答考生答案插入数据库
 * @author taominqi
 *
 */
public class InsertBaseAnswer {
	
	private String baseId;
	private String account;
	private String bEssayId;
	private String bAnswer;
	
	public InsertBaseAnswer() {
		// TODO Auto-generated constructor stub
	}

	public InsertBaseAnswer(String baseId,String account, String bEssayId, String bAnswer) {
		super();
		this.setBaseId(baseId);
		this.account = account;
		this.bEssayId = bEssayId;
		this.bAnswer = bAnswer;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getbEssayId() {
		return bEssayId;
	}

	public void setbEssayId(String bEssayId) {
		this.bEssayId = bEssayId;
	}

	public String getbAnswer() {
		return bAnswer;
	}

	public void setbAnswer(String bAnswer) {
		this.bAnswer = bAnswer;
	}

	public String getBaseId() {
		return baseId;
	}

	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}
	

}
