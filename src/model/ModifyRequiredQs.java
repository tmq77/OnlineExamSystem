package model;

/**
 * 修改必答题的数据类--综合题
 * @author taominqi
 *
 */
public class ModifyRequiredQs {
	private int rid;
	private String title;
	private String rright;
	private String post;
	public ModifyRequiredQs() {
		// TODO Auto-generated constructor stub
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRright() {
		return rright;
	}
	public void setRright(String rright) {
		this.rright = rright;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public ModifyRequiredQs(int rid, String title, String rright, String post) {
		super();
		this.rid = rid;
		this.title = title;
		this.rright = rright;
		this.post = post;
	}
	
}

