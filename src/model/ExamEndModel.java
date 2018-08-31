package model;

public class ExamEndModel {
	private String id;
	private String name;
	private int baseSingle;
	
	public ExamEndModel() {
		// TODO Auto-generated constructor stub
	}

	
	
	public ExamEndModel(String id, String name,int baseSingle) {
		super();
		this.id = id;
		this.name = name;
		this.baseSingle = baseSingle;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSingle() {
		return baseSingle;
	}

	public void setBaseSingle(int baseSingle) {
		this.baseSingle = baseSingle;
	}
	

}
