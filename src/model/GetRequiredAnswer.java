package model;

/**数据类存放阅卷页面的取出的必答题和录音题
 * @author taominqi
 *
 */
public class GetRequiredAnswer {

	private String title;  //综合题标题
	private String rright; //综合题正确答案
	private String vright; //录音题正确答案
	private String ranswer; //综合题考生答案
	private String vanswer;//录音题考生答案
	public GetRequiredAnswer() {
		// TODO Auto-generated constructor stub
	}
	public GetRequiredAnswer(String title, String rright,String vright, String ranswer,String vanswer) {
		super();
		this.title = title;
		this.setRright(rright);
		this.vright=vright;
		this.ranswer = ranswer;
		this.vanswer = vanswer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getVanswer() {
		return vanswer;
	}
	public void setVanswer(String vanswer) {
		this.vanswer = vanswer;
	}
	public String getRanswer() {
		return ranswer;
	}
	public void setRanswer(String ranswer) {
		this.ranswer = ranswer;
	}
	public String getVright() {
		return vright;
	}
	public void setVright(String vright) {
		this.vright = vright;
	}
	public String getRright() {
		return rright;
	}
	public void setRright(String rright) {
		this.rright = rright;
	}
	
}
