package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.RequiredQs;

public interface GetRequiredQsDao {
	
	@Select( "SELECT rid,title FROM requiredqs WHERE post = #{post}")
	RequiredQs getReQs(@Param("post")String post);

}
