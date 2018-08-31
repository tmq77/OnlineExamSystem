package service.impl;

import mapper.DeleteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.Delete;

/**
 * 删除组件
 * @author Administrator
 *
 */
@Transactional
@Service("deleteImpl")
public class DeleteImpl implements Delete{

	@Autowired
	private DeleteDao deleteDao;
	
	/**
	 * @return 
	 * 1 删除成功
	 */
	public int delete(String username) {
		
		
		deleteDao.deleteUser(username);
		return 1;
	}
}
