package mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.dao.DataAccessException;

import model.BaseQs;
import model.SaveBaseEssay;

public interface AddBaseQsDao {
	
	@Insert("INSERT INTO exam_basesingle(BaseSingleTitle,BaseSingleA,BaseSingleB,BaseSingleC,BaseSingleD,BaseSingleAS) VALUES(#{baseSingleTitle},#{baseSingleA},#{baseSingleB},#{baseSingleC},#{baseSingleD},#{baseSingleAS})")
	int addBaseSingle(BaseQs baseQs)throws DataAccessException;
	
	@Insert("INSERT INTO baseessay(essayTitle,essayRight) VALUES(#{essayTitle},#{essayRight})")
	int addBaseEssay(SaveBaseEssay saveBaseEssay)throws DataAccessException;
}
