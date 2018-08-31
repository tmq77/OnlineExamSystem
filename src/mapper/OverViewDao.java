package mapper;

import java.util.List;
import model.OverViewUser;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface OverViewDao {

	

	@Select("SELECT name,account,pass,post,status,time FROM user_interviewer ORDER BY status LIMIT #{pageNo},6")
	@Results({
		@Result(column="name",property="name"),
		@Result(column="account",property="username"),
		@Result(column="pass",property="password"),
		@Result(column="post",property="post"),
		@Result(column="status",property="status"),
		@Result(column="time",property="time")
	})
	public List<OverViewUser> SelectData(@Param("pageNo")int pageNo);
	
	@Select("SELECT count(*) FROM user_interviewer")
	public int totalPage();

}
