package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface DeleteAdminDao {
	
	@Delete("DELETE FROM user_admin WHERE account = #{username}")
	int deleteAdminUser(@Param("username")String username);

}
