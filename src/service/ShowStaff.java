package service;

import java.util.List;

import model.Staff;

public interface ShowStaff {

	int staffTotalPage();
	
	List<Staff> showStaff(int pageNo);
	
	
}
