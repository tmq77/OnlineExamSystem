package model;

/**
 * 存放需要打印的单选数据
 * @author taomi_000
 *
 */

public class PaperBaseQs {
	
	private String uuid;
	private String account;
	private String singletitle;
	private String singleA;
	private String singleB;
	private String singleC;
	private String singleD;
	private String singleAs;
	private String singleUs;

	public PaperBaseQs() {
		// TODO Auto-generated constructor stub
	}

	public PaperBaseQs(String singletitle, String singleA, String singleB, String singleC, String singleD,
			String singleAs) {
		super();
		this.singletitle = singletitle;
		this.singleA = singleA;
		this.singleB = singleB;
		this.singleC = singleC;
		this.singleD = singleD;
		this.singleAs = singleAs;
	}

	public PaperBaseQs(String uuid, String account, String singletitle, String singleA, String singleB, String singleC,
			String singleD, String singleAs, String singleUs) {
		super();
		this.uuid = uuid;
		this.account = account;
		this.singletitle = singletitle;
		this.singleA = singleA;
		this.singleB = singleB;
		this.singleC = singleC;
		this.singleD = singleD;
		this.singleAs = singleAs;
		this.singleUs = singleUs;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSingletitle() {
		return singletitle;
	}

	public void setSingletitle(String singletitle) {
		this.singletitle = singletitle;
	}

	public String getSingleA() {
		return singleA;
	}

	public void setSingleA(String singleA) {
		this.singleA = singleA;
	}

	public String getSingleB() {
		return singleB;
	}

	public void setSingleB(String singleB) {
		this.singleB = singleB;
	}

	public String getSingleC() {
		return singleC;
	}

	public void setSingleC(String singleC) {
		this.singleC = singleC;
	}

	public String getSingleD() {
		return singleD;
	}

	public void setSingleD(String singleD) {
		this.singleD = singleD;
	}

	public String getSingleAs() {
		return singleAs;
	}

	public void setSingleAs(String singleAs) {
		this.singleAs = singleAs;
	}

	public String getSingleUs() {
		return singleUs;
	}

	public void setSingleUs(String singleUs) {
		this.singleUs = singleUs;
	}
	
}
