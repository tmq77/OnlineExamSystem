package mapper;

import model.ModifyRequiredQs;
import org.apache.ibatis.annotations.Update;

public interface ModifyRequiredQsDao {

	@Update("UPDATE required_info SET title = #{title}, rright = #{rright} WHERE rid = #{rid}")
	int modifyRequired(ModifyRequiredQs modifyRequiredQs);
}
