package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface DeleteDao {
	
	@Delete("DELETE FROM user_interviewer WHERE account = #{username}")
	void deleteUser(@Param("username")String username);

}
