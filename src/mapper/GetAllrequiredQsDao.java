package mapper;

import java.util.ArrayList;

import model.ModifyRequiredQs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GetAllrequiredQsDao {
	
	@Select("SELECT * FROM required_info WHERE post = #{post} LIMIT #{index},4")
	ArrayList<ModifyRequiredQs> allRequiredQs(@Param("post")String post,@Param("index")int index);
	
	@Select("SELECT count(*) FROM required_info WHERE post = #{post}")
	int getTotalCounts(@Param("post")String post);

}
