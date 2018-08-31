package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import model.AdminUser;

/**
 * 获取所有的管理员
 * @author taominqi
 *
 */
public interface ShowAdminDao {
	
	@Select("SELECT account FROM user_admin")
	ArrayList<AdminUser> getAllAdmin();
}
