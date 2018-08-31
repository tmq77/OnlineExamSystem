package service.impl;

import mapper.DeleteAdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.DeleteAdmin;

/**
 * 删除管理员业务组件
 * @author taominqi
 *
 */
@Transactional
@Service("deleteAdminImpl")
public class DeleteAdminImpl implements DeleteAdmin{

	@Autowired
	private DeleteAdminDao deleteAdminDao;
	
	public int deleteAdmin(String username) {
		int flag = deleteAdminDao.deleteAdminUser(username);
		if(flag==0){
			return -1;//删除失败
		}
		return 0;
	}

}
