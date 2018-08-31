package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.ShowStaffDao;
import model.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ShowStaff;

@Transactional
@Service("showStaffImpl")
public class ShowStaffImpl implements ShowStaff{

	@Autowired
	private ShowStaffDao showStaffDao;
	
	public int staffTotalPage() {
		int total = showStaffDao.showTotalPage();
		int pageSize = (total%6)==0?(total/6):((total/6)+1);
		return pageSize;
	}

	public List<Staff> showStaff(int pageNo) {
		ArrayList<Staff> staff = new ArrayList<Staff>();
		staff = showStaffDao.getAllStaff(pageNo);
		return staff;
	}

}
