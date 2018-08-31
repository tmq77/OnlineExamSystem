package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface DeleteSingleDao {
	
	@Delete("DELETE FROM exam_basesingle WHERE eid = #{eid}")
	int deleteSingle(@Param("eid")int eid);

}
