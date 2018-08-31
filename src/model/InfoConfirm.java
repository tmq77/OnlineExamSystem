package model;


public class InfoConfirm {
	private String name;
	private String account;
	private String post;
	
	public InfoConfirm(){}
	
	public InfoConfirm(String name, String account, String post) {
		super();
		this.name = name;
		this.account = account;
		this.post = post;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	

}
