package model;

public class SaveProEssay {
	private String eTitle;
	private String eRight;
	private String post;
	public SaveProEssay(String eTitle, String eRight, String post) {
		super();
		this.eTitle = eTitle;
		this.eRight = eRight;
		this.post = post;
	}
	public SaveProEssay() {
		// TODO Auto-generated constructor stub
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteRight() {
		return eRight;
	}
	public void seteRight(String eRight) {
		this.eRight = eRight;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	
	

}
