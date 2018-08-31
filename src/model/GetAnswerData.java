package model;

public class GetAnswerData {
	private String eTitle="";
	private String eRight="";
	private String answer="";
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public GetAnswerData(String eTitle, String eRight, String answer) {
		super();
		this.eTitle = eTitle;
		this.eRight = eRight;
		this.answer = answer;
	}
	public GetAnswerData() {
		// TODO Auto-generated constructor stub
	}
	 

}
