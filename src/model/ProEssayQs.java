package model;

/**
 * 数据类
 * 存放取出专业问答的 问题、参考答案、问题标志号
 * @author Administrator
 *
 */
public class ProEssayQs {
	
	private String eTitle;
	private int essayId;
	
	public ProEssayQs() {
		// TODO Auto-generated constructor stub
	}
	
	public ProEssayQs(String eTitle,int essayId){
		super();
		this.eTitle=eTitle;
		this.essayId=essayId;
		
	}
	
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	
	public int getEssayId() {
		return essayId;
	}
	public void setEssayId(int essayId) {
		this.essayId = essayId;
	}
	
	

}
