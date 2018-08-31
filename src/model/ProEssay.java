package model;

public class ProEssay {
	private String etitle;
	private String eright;
	private String post;
	private int essayId;
	
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
	public String getEright() {
		return eright;
	}
	public void setEright(String eright) {
		this.eright = eright;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getEssayId() {
		return essayId;
	}
	public void setEssayId(int essayId) {
		this.essayId = essayId;
	}
	
	public ProEssay() {
		// TODO Auto-generated constructor stub
	}
	public ProEssay(String etitle, String eright, String post, int essayId) {
		super();
		this.etitle = etitle;
		this.eright = eright;
		this.post = post;
		this.essayId = essayId;
	}
	
}
