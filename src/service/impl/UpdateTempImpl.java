package service.impl;

import mapper.UpdateTempDao;
import model.UpdateUserTemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.UpdateTemp;


@Transactional
@Service("updateTempImpl")
public class UpdateTempImpl implements UpdateTemp {
	@Autowired
	private UpdateTempDao updateTempDao;


	public UpdateUserTemp temp(String username) {
		 UpdateUserTemp ud = updateTempDao.updateUser(username);
		return ud;

	}
}
