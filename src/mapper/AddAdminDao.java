package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 录入新的管理员
 * @author taominqi
 *
 */
public interface AddAdminDao {
	
	@Insert("INSERT INTO user_admin(name,account,pass) VALUES('管理员',#{username},#{password})")
	int addAdmin(@Param("username")String username,@Param("password")String password);

}
