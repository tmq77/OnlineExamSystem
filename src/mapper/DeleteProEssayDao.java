package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface DeleteProEssayDao {

	@Delete("DELETE FROM essay WHERE essayId = #{essayId}")
	int deleteBaseEssay(@Param("essayId")int essayId);
}
