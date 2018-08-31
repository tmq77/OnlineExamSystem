package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ModifyAdminDao {
	
	@Update("UPDATE user_admin SET account = #{username} ,pass = #{password} WHERE account = #{usernameold}")
	int modify(@Param("username")String username,@Param("password")String password,@Param("usernameold")String usernameold);

}
