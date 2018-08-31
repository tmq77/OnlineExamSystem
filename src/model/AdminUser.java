package model;

import java.io.Serializable;

public class AdminUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -701670714334023137L;
	private String name;
	private String account;
	private String pass;
	private int aid;
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminUser(int aid,String name, String account, String pass) {
		super();
		this.name = name;
		this.account = account;
		this.pass = pass;
		this.aid=aid;
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
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

	
}
