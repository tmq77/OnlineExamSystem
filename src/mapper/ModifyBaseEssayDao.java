package mapper;

import org.apache.ibatis.annotations.Update;

import model.BaseEssay;

public interface ModifyBaseEssayDao {

	@Update("UPDATE baseessay SET essayTitle = #{essayTitle}, essayRight = #{essayRight} WHERE essayId = #{essayId}")
	int modifyBaseDao(BaseEssay baseEssay);
}
