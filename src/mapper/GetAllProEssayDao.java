package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.ProEssay;

public interface GetAllProEssayDao {
	
	@Select("SELECT * FROM essay WHERE post = #{post} LIMIT #{index},4")
	ArrayList<ProEssay> allProEssay(@Param("post")String post,@Param("index")int index);
	
	@Select("SELECT count(*) FROM essay WHERE post = #{post}")
	int getTotalCounts(@Param("post")String post);
}
