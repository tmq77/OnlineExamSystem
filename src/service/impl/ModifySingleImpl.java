package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.ModifySingleDao;
import model.BaseQs;
import service.ModifySingle;

/**
 * 更新试题-单选
 * @author taominqi
 *
 */
@Transactional
@Service("modifySingleImpl")
public class ModifySingleImpl implements ModifySingle{

	@Autowired
	private ModifySingleDao modifySingleDao;
	
	public int modifySingle(BaseQs baseQs) {

		return modifySingleDao.modifySingle(baseQs);
	}

}
