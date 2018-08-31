package mapper;

import java.util.List;

import model.BaseQs;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface GetBaseQsDao {
	
	@Select("SELECT * FROM exam_basesingle ORDER BY rand() LIMIT 20")
	@Results({
		@Result(column="BaseSingleTitle",property="baseSingleTitle"),
		@Result(column="BaseSingleA",property="baseSingleA"),
		@Result(column="BaseSingleB",property="baseSingleB"),
		@Result(column="BaseSingleC",property="baseSingleC"),
		@Result(column="BaseSingleD",property="baseSingleD"),
		@Result(column="BaseSingleAS",property="baseSingleAS")
	})
	List<BaseQs> selectBaseQs();

}
