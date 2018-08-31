package model;

public class UpdateUserTemp {
	private String name;
	private String account;
	private String uid;
	private String post;
	private String email;
	
	
	public UpdateUserTemp(){}
	
	public UpdateUserTemp(String name, String account,String uid,String post,String email) {
		super();
		this.name = name;
		this.account = account;
		this.uid=uid;
		this.post = post;
		this.email = email;
	}
	
	public UpdateUserTemp(String name, String account,String uid,String post) {
		super();
		this.name = name;
		this.account = account;
		this.uid=uid;
		this.post = post;
	}
	
	public UpdateUserTemp(String name, String account,String uid) {
		super();
		this.name = name;
		this.account = account;
		this.uid=uid;
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
