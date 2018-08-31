package mapper;

import model.BaseQs;

import org.apache.ibatis.annotations.Update;

public interface ModifySingleDao {

	@Update("UPDATE exam_basesingle SET BaseSingleTitle = #{baseSingleTitle},BaseSingleA = #{baseSingleA},BaseSingleB = #{baseSingleB},BaseSingleC = #{baseSingleC},BaseSingleD = #{baseSingleD},BaseSingleAS = #{baseSingleAS} WHERE eid = #{eid}")
	int modifySingle(BaseQs baseQs);
}
