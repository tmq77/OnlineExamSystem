package mapper;

import model.AdminUser;
import model.InterUser;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 登录的持久层
 *
 */
public interface LoginDao {
	
	@Select("SELECT * FROM user_interviewer WHERE account = #{username}")
	 InterUser findInterUser(@Param("username")String username);
	
	@Select("SELECT * FROM user_admin WHERE account = #{username}")
	AdminUser findAdminUser(@Param("username")String username);

}
