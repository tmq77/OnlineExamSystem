package mapper;

import model.ProEssay;

import org.apache.ibatis.annotations.Update;

public interface ModifyProEssayDao {
	
	@Update("UPDATE essay SET eTitle = #{etitle}, eRight = #{eright} WHERE essayId = #{essayId}")
	int modifyProDao(ProEssay proEssay);

}
