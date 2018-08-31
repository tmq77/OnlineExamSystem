package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ParseXlsDao {
	
	@Insert("INSERT INTO exam_basesingle(BaseSingleTitle,BaseSingleA,BaseSingleB,BaseSingleC,BaseSingleD,BaseSingleAS) VALUES(#{baseSingleTitle},#{baseSingleA},#{baseSingleB},#{baseSingleC},#{baseSingleD},#{baseSingleAS})")
	int insertExam(model.BaseQs baseQs);
	
	@Select("SELECT count(BaseSingleTitle) FROM exam_basesingle WHERE BaseSingleTitle = #{title}")
	int counts(@Param("title")String title);

}
