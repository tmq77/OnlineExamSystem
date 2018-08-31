package model;
/**
 * 数据类
 * 存放取出逻辑问答题的 问题、参考答案、问题标志号
 * @author Administrator
 *
 */

public class EssayQs {
	private String essayTitle;
	private int essayId;
	public EssayQs() {
		// TODO Auto-generated constructor stub
	}
	public EssayQs(String essayTitle, int essayId) {
		super();
		this.essayTitle = essayTitle;
		this.essayId = essayId;
	}
	
	public String getEssayTitle() {
		return essayTitle;
	}
	public void setEssayTitle(String essayTitle) {
		this.essayTitle = essayTitle;
	}
	public int getEssayId() {
		return essayId;
	}
	public void setEssayId(int essayId) {
		this.essayId = essayId;
	}
	

}
