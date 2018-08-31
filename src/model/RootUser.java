package model;

/**
 * 超级管理员数据类
 * @author taominqi
 *
 */
public class RootUser {

	private String username;
	private String password;
	private int id;
	public RootUser() {
		// TODO Auto-generated constructor stub
	}
	public RootUser(String username, String password, int id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
