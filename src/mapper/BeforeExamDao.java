package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.InfoConfirm;

public interface BeforeExamDao {
	
	@Select( "SELECT name,account,post FROM user_interviewer WHERE account = #{username}")
	InfoConfirm userConfirm(@Param("username")String username);

}
