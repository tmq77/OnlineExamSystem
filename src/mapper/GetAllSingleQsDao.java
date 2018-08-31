package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.BaseQs;

/**
 * 获取所有的单选题 --修改
 * @author taominqi
 *
 */
public interface GetAllSingleQsDao {
	
	@Select("SELECT * FROM exam_basesingle LIMIT #{index},8")
	@Results({
		@Result(column="BaseSingleTitle",property="baseSingleTitle"),
		@Result(column="BaseSingleA",property="baseSingleA"),
		@Result(column="BaseSingleB",property="baseSingleB"),
		@Result(column="BaseSingleC",property="baseSingleC"),
		@Result(column="BaseSingleD",property="baseSingleD"),
		@Result(column="BaseSingleAS",property="baseSingleAS"),
		@Result(column="eid",property="eid")
	})
	ArrayList<BaseQs> getAllQs(@Param("index")int index);
	
	@Select("SELECT count(*) FROM exam_basesingle")
	int getCounts();

}
