package model;

/**
 * 数据类存放取出的必答题
 * @author taominqi
 *
 */
public class RequiredQs {
	private String rid;
	private String title;
	public RequiredQs() {
		// TODO Auto-generated constructor stub
	}

	public RequiredQs(String rid, String title) {
		super();
		this.rid = rid;
		this.title = title;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

}
