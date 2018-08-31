package model;

/**
 * 逻辑单选封装类
 * @author Administrator
 *
 */
public class BaseQs {
	private String baseSingleTitle;
	private String baseSingleA;
	private String baseSingleB;
	private String baseSingleC;
	private String baseSingleD;
	private String baseSingleAS;
	private int eid;
	
	
	public BaseQs() {
		// TODO Auto-generated constructor stub
	}
	public BaseQs(String baseSingleTitle, String baseSingleA,
			String baseSingleB, String baseSingleC, String baseSingleD,
			String baseSingleAS) {
		super();
		this.baseSingleTitle = baseSingleTitle;
		this.baseSingleA = baseSingleA;
		this.baseSingleB = baseSingleB;
		this.baseSingleC = baseSingleC;
		this.baseSingleD = baseSingleD;
		this.baseSingleAS = baseSingleAS;
	}
	
	public BaseQs(String baseSingleTitle, String baseSingleA, String baseSingleB, String baseSingleC,
			String baseSingleD, String baseSingleAS, int eid) {
		super();
		this.baseSingleTitle = baseSingleTitle;
		this.baseSingleA = baseSingleA;
		this.baseSingleB = baseSingleB;
		this.baseSingleC = baseSingleC;
		this.baseSingleD = baseSingleD;
		this.baseSingleAS = baseSingleAS;
		this.eid = eid;
	}
	public String getBaseSingleTitle() {
		return baseSingleTitle;
	}
	public void setBaseSingleTitle(String baseSingleTitle) {
		this.baseSingleTitle = baseSingleTitle;
	}
	public String getBaseSingleA() {
		return baseSingleA;
	}
	public void setBaseSingleA(String baseSingleA) {
		this.baseSingleA = baseSingleA;
	}
	public String getBaseSingleB() {
		return baseSingleB;
	}
	public void setBaseSingleB(String baseSingleB) {
		this.baseSingleB = baseSingleB;
	}
	public String getBaseSingleC() {
		return baseSingleC;
	}
	public void setBaseSingleC(String baseSingleC) {
		this.baseSingleC = baseSingleC;
	}
	public String getBaseSingleD() {
		return baseSingleD;
	}
	public void setBaseSingleD(String baseSingleD) {
		this.baseSingleD = baseSingleD;
	}
	public String getBaseSingleAS() {
		return baseSingleAS;
	}
	public void setBaseSingleAS(String baseSingleAS) {
		this.baseSingleAS = baseSingleAS;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	
	
	

}