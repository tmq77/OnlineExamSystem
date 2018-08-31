package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.RootUser;

public interface RootLoginDao {
	
	@Select("SELECT * FROM user_root WHERE username = #{username}")
	RootUser judgeRoot(@Param("username")String username);

}
