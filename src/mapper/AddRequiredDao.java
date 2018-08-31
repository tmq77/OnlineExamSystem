package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

public interface AddRequiredDao {
	
	@Insert("INSERT INTO required_info(title,rright,post) VALUES(#{allTitle},#{allRight},#{course})")
	public int AddRequiredQs(@Param("course")String course,@Param("allTitle")String allTitle,@Param("allRight")String allRight)throws DataAccessException;

}
