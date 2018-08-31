package service.impl;

import mapper.DeleteStaffDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.DeleteStaff;

@Transactional
@Service("deleteStaffImpl")
public class DeleteStaffImpl implements DeleteStaff{
	@Autowired
	private DeleteStaffDao deleteStaff;

	@Override
	public int deleteTheStaff(String username) {
		if(deleteStaff.deleteStaff(username)==0){
			return -1;
		}
		
		if(deleteStaff.deletePrintAllExam(username)==0){
			return -1;
		}
		
		if(deleteStaff.deletePrintBaseExam(username)==0){
			return -1;
		}
		
		if(deleteStaff.deletePrintProExam(username)==0){
			return -1;
		}
		
		if(deleteStaff.deletePrintSingle(username)==0){
			return -1;
		}
		
		if(deleteStaff.deletePrintAudioExam(username)==0){
			return -1;
		}
		return 0;
		
	}

}
