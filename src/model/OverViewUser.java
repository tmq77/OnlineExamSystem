package model;

public class OverViewUser {
	private String name;
	private String username;
	private String password;
	private String post;
	private String status;
	private String time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post=post;
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status.equals("f")){
			this.status="未考试";
		}else{
			this.status="已考试";
		}
	}
	public OverViewUser(String name, String username, String password,
			String post, String status) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.post = post;
		this.status = status;
	}
	public OverViewUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
