package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


/**
 * 添加人员的持久层
 *
 */
public interface AddUserDao {
	
	@Insert("INSERT INTO user_interviewer(uid,name,account,pass,post,email,time) VALUES(#{uid},#{name},#{username},#{password},#{post},#{mail},#{time})")
	int addUser(@Param("uid")String uid,@Param("name")String name,@Param("username")String username,@Param("password")String password,@Param("post")String post,@Param("mail")String mail,@Param("time")String time);

}
