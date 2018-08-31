package model;

public class InsertRequiredAnswer {
	
	private String id;
	private String rid;
	private String ranswer;
	private String account;
	public InsertRequiredAnswer() {
		// TODO Auto-generated constructor stub
	}
	public InsertRequiredAnswer(String id,String rid, String ranswer, 
			String account) {
		super();
		this.id=id;
		this.rid = rid;
		this.ranswer = ranswer;
		this.account = account;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRanswer() {
		return ranswer;
	}
	public void setRanswer(String ranswer) {
		this.ranswer = ranswer;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
