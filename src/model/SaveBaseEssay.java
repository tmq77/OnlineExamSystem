package model;


/**
 * 数据类存放基础简答题
 * @author taominqi
 *
 */
public class SaveBaseEssay {
	private String essayTitle;
	private String essayRight;
	
	public SaveBaseEssay() {
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

	public SaveBaseEssay(String essayTitle, String essayRight) {
		super();
		this.essayTitle = essayTitle;
		this.essayRight = essayRight;
	}
	

}
