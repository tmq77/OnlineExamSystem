package service;

import java.util.List;
import model.OverViewUser;

public interface OverView{
	
	public List<OverViewUser> OverData(int pageNo);
	public int totalPage();
}