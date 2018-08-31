package service.impl;

import java.util.ArrayList;

import mapper.ShowAdminDao;
import model.AdminUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ShowAdmin;

/**
 * 获取所有的管理员账号的业务组件
 * @author taominqi
 *
 */
@Transactional
@Service("showAdminImpl")
public class ShowAdminImpl implements ShowAdmin{

	@Autowired
	private ShowAdminDao showAdminDao;

	public ArrayList<AdminUser> show() {
		
		return showAdminDao.getAllAdmin();
	}

}
