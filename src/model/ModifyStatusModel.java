package model;

/**
 * 精确获取考试状态的数据类
 * @author taominqi
 *
 */
public class ModifyStatusModel {

	private String account;
	private String status;
	public ModifyStatusModel() {
		// TODO Auto-generated constructor stub
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ModifyStatusModel(String account, String status) {
		super();
		this.account = account;
		this.status = status;
	}
	
}
