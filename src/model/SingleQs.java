package model;

public class SingleQs {
	
	private String sTitle;
	private String sOptionA;
	private String sOptionB;
	private String sOptionC;
	private String sOptionD;
	private String sOptionR;
	private String post;
	private int sId;
	
	public SingleQs(String sTitle,String sOptionA,String sOptionB,String sOptionC,String sOptionD,String sOptionR){
		this.sTitle = sTitle;
		this.sOptionA= sOptionA;
		this.sOptionB = sOptionB;
		this.sOptionC= sOptionC;
		this.sOptionD = sOptionD;
		this.sOptionR=sOptionR;
	}
	
	public SingleQs(String sTitle,String sOptionA,String sOptionB,String sOptionC,String sOptionD,String sOptionR,String post){
		this.sTitle = sTitle;
		this.sOptionA= sOptionA;
		this.sOptionB = sOptionB;
		this.sOptionC= sOptionC;
		this.sOptionD = sOptionD;
		this.sOptionR=sOptionR;
		this.post=post;
	}
	public SingleQs() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SingleQs(String sTitle, String sOptionA, String sOptionB,
			String sOptionC, String sOptionD, String sOptionR, String post,
			int sId) {
		super();
		this.sTitle = sTitle;
		this.sOptionA = sOptionA;
		this.sOptionB = sOptionB;
		this.sOptionC = sOptionC;
		this.sOptionD = sOptionD;
		this.sOptionR = sOptionR;
		this.post = post;
		this.sId = sId;
	}

	public String getsTitle() {
		return sTitle;
	}
	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
	public String getsOptionA() {
		return sOptionA;
	}
	public void setsOptionA(String sOptionA) {
		this.sOptionA = sOptionA;
	}
	public String getsOptionB() {
		return sOptionB;
	}
	public void setsOptionB(String sOptionB) {
		this.sOptionB = sOptionB;
	}
	public String getsOptionC() {
		return sOptionC;
	}
	public void setsOptionC(String sOptionC) {
		this.sOptionC = sOptionC;
	}
	public String getsOptionD() {
		return sOptionD;
	}
	public void setsOptionD(String sOptionD) {
		this.sOptionD = sOptionD;
	}
	public String getsOptionR() {
		return sOptionR;
	}
	public void setsOptionR(String sOptionR) {
		this.sOptionR = sOptionR;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	
	

}
