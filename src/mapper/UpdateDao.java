package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

public interface UpdateDao {
	
	@Update("UPDATE user_interviewer SET name = #{name},account = #{username},pass = #{password},post = #{post},email = #{mail} WHERE uid = #{id}")
	void updateUser(@Param("id")String id,@Param("name")String name,@Param("username")String username,@Param("password")String password,@Param("post")String post,@Param("mail")String mail)throws DataAccessException;

}
