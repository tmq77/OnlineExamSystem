package service.impl;

import java.util.ArrayList;
import java.util.List;
import mapper.OverViewDao;
import model.OverViewUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.OverView;


@Transactional
@Service("overViewImpl")
public class OverViewImpl implements OverView{

	@Autowired
	private OverViewDao overViewDao;
	
	
	public List<OverViewUser> OverData(int index) {
		List<OverViewUser> dataInfo = new ArrayList<>(); // 存放数据行的动态数组集合；
		
		dataInfo=overViewDao.SelectData(index);
		return dataInfo;
	}
	
	public int totalPage(){
		int total = overViewDao.totalPage();
		int pageSize = (total%6)==0?(total/6):((total/6)+1);
		return pageSize;
		
	}

}
