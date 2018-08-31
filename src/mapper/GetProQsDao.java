package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.SingleQs;

public interface GetProQsDao {
	
	@Select("SELECT * FROM single WHERE post = #{post} ORDER BY rand() LIMIT 20")
	List<SingleQs> getQs(@Param("post")String post);
	
	@Update("UPDATE user_interviewer SET status = 't' WHERE account= #{username}")
	void modifyStatus(String username);
	
	@Select("SELECT post FROM user_interviewer WHERE account = #{username}")
	String select(@Param("username")String username);
}
