package service.impl;

import mapper.DeleteRequiredQsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.DeleteRequiredQs;

/**
 * 删除综合题的业务层
 * @author taominqi
 *
 */
@Transactional
@Service("deleteRequiredQsImpl")
public class DeleteRequiredQsImpl implements DeleteRequiredQs{

	@Autowired
	private DeleteRequiredQsDao deleteRequiredQsDao;
	@Override
	public int deleteRequired(int rid) {
		return deleteRequiredQsDao.deleteRequiredQs(rid);
	}

}
