package model;

public class BaseEssay {
	
	private String essayTitle;
	private String essayRight;
	private int essayId;
	public BaseEssay() {
		// TODO Auto-generated constructor stub
	}
	public String getEssayTitle() {
		return essayTitle;
	}
	public void setEssayTitle(String essayTitle) {
		this.essayTitle = essayTitle;
	}
	public String getEssayRight() {
		return essayRight;
	}
	public void setEssayRight(String essayRight) {
		this.essayRight = essayRight;
	}
	
	public BaseEssay(String essayTitle, String essayRight, int essayId) {
		super();
		this.essayTitle = essayTitle;
		this.essayRight = essayRight;
		this.setEssayId(essayId);
	}
	public int getEssayId() {
		return essayId;
	}
	public void setEssayId(int essayId) {
		this.essayId = essayId;
	}
	

}
