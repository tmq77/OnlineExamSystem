package service.impl;

import mapper.DeleteSingleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.DeleteSingle;

@Transactional
@Service("deleteSingleImpl")
public class DeleteSingleImpl implements DeleteSingle{

	@Autowired
	private DeleteSingleDao deleteSingleDao;
	
	public int deleteSingle(int eid) {
		
		return deleteSingleDao.deleteSingle(eid);
	}

}
