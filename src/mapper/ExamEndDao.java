package mapper;

import model.ExamEndModel;

import org.apache.ibatis.annotations.Insert;
import org.springframework.dao.DataAccessException;

public interface ExamEndDao {
	
	@Insert("INSERT INTO score(id,name,baseSingle) VALUES(#{id},#{name},#{baseSingle})")
	int examEnd(ExamEndModel examEndModel)throws DataAccessException;

}
