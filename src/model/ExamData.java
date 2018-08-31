package model;

/**
 * 数据封装类，用于存储 人员姓名、考试单选分数，简答的答案的链接
 * @author Administrator
 *
 */
public class ExamData {
	private String name="";
	private String account="";
	private String post="";
	private int baseSingle=0;
	private String email="";
	
	public ExamData() {
		// TODO Auto-generated constructor stub
	}
	
	public ExamData(String name, String account,String post, int baseSingle,String email) {
		super();
		this.name = name;
		this.account=account;
		this.post = post;
		this.baseSingle = baseSingle;
		this.email = email;
	}

	public ExamData(String name, String account,String post, int baseSingle) {
		super();
		this.name = name;
		this.account=account;
		this.post = post;
		this.baseSingle = baseSingle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getBaseSingle() {
		return baseSingle;
	}
	public void setBaseSingle(int baseSingle) {
		this.baseSingle = baseSingle;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
