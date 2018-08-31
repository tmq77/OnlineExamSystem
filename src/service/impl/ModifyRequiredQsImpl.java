package service.impl;

import mapper.ModifyRequiredQsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ModifyRequiredQs;

@Transactional
@Service("modifyRequiredQsImpl")
public class ModifyRequiredQsImpl implements ModifyRequiredQs{

	@Autowired
	private ModifyRequiredQsDao modifyRequiredQsDao;
	
	public int modifyReq(String title, String rright, int rid, String post) {
		model.ModifyRequiredQs modifyRequiredQs = new model.ModifyRequiredQs(rid, title, rright, post);
		return modifyRequiredQsDao.modifyRequired(modifyRequiredQs);
	}

}
