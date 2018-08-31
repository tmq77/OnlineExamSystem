package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.PaperBaseQs;

public interface InsertSingleQsTempDao {
	
	/**
	 * 获取当前id的单选题
	 * @param eid
	 * @return
	 */
	@Select("SELECT * FROM exam_basesingle WHERE eid = #{eid}")
	@Results({
		@Result(column="BaseSingleTitle",property="singletitle"),
		@Result(column="BaseSingleA",property="singleA"),
		@Result(column="BaseSingleB",property="singleB"),
		@Result(column="BaseSingleC",property="singleC"),
		@Result(column="BaseSingleD",property="singleD"),
		@Result(column="BaseSingleAS",property="singleAs")
	})
	PaperBaseQs getBaseSingle(@Param("eid")int eid);
	
	/**
	 * 将需要打印的单选信息插入临时表
	 * @param paperBaseQs
	 * @return
	 */
	@Insert("INSERT INTO printsingle_temp VALUES(#{uuid},#{account},#{singletitle},#{singleA},#{singleB},#{singleC},#{singleD},#{singleAs},#{singleUs})")
	int insertSingleTemp(PaperBaseQs paperBaseQs);
}
