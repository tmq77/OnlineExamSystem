package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.UpdateUserTemp;

public interface UpdateTempDao {
	
	@Select("SELECT uid,name,account,post,email FROM user_interviewer WHERE account = #{username}")
	UpdateUserTemp updateUser(@Param("username")String username);

}
