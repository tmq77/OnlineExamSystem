package model;

import java.io.Serializable;

public class InterUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8900863379511650990L;
	private String uid;
	private String name;
	private String account;
	private String pass;
	private String post;
	private String status;
	
	public InterUser(){}

	public InterUser(String uid,String name, String account, String pass, String post,
			String status) {
		super();
		this.uid=uid;
		this.name = name;
		this.account = account;
		this.pass = pass;
		this.post = post;
		this.status = status;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
