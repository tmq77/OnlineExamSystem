package model;

public class Staff {

	private String name;
	private String phone;
	private String post;
	private String email;
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Staff(String name, String phone, String post) {
		super();
		this.name = name;
		this.phone = phone;
		this.post = post;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Staff(String name, String phone, String post,String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.post = post;
		this.email=email;
	}
  
	
	
}
