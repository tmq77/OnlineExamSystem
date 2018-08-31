package service.impl;

import java.util.ArrayList;
import java.util.List;

import mapper.ModifyStatusDao;
import model.ModifyStatusModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ModifyStatusService;

@Transactional
@Service("modifyStatusImpl")
public class ModifyStatusImpl implements ModifyStatusService{
	
	@Autowired
	private ModifyStatusDao modifyStatusdao;

	@Override
	public ArrayList<String> modifyData(int index) {
		List<ModifyStatusModel> modifyUser = new ArrayList<>(); // 存放数据行的动态数组集合；
		modifyUser =  modifyStatusdao.getModifyUser(index);
		ArrayList<String> userList = new ArrayList<>();  //存放需要修改二次状态的人员账号
		for(int i =0;i<modifyUser.size();i++){
			String username= modifyUser.get(i).getAccount();
			String status = modifyUser.get(i).getStatus();
			if("t".equals(status)){//已经考试了
				//查询成绩表中的对应记录，如果没有则中途退出了；
				int flag = modifyStatusdao.getExamCount(username);
				if(flag==0){//此人中途退出
					userList.add(username);
				}
			}
		}
		
		 
		return userList;
	}

	
	@Override
	public int totalPage() {
		int total = modifyStatusdao.totalPage();
		int pageSize = (total%6)==0?(total/6):((total/6)+1);
		return pageSize;
	}

}
