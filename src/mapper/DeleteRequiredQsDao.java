package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface DeleteRequiredQsDao {

	@Delete("DELETE FROM required_info WHERE rid = #{rid}")
	int deleteRequiredQs(@Param("rid")int rid);
}
