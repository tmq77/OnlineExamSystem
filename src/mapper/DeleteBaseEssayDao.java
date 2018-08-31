package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface DeleteBaseEssayDao {

	@Delete("DELETE FROM baseessay WHERE essayId = #{essayId}")
	int deleteBaseEssay(@Param("essayId")int essayId);
}
