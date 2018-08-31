package mapper;

import java.util.ArrayList;
import model.BaseQs;
import model.EssayQs;
import model.ProEssayQs;
import model.RequiredQs;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 持久层,取出数据
 * @author taominqi
 * @time 2017年3月3日15:34:11
 */
public interface GetExamQsDao {
	
	/**
	 * 取出逻辑问答
	 * @return
	 */
	@Select("SELECT essayTitle,essayId FROM baseessay ORDER BY rand() LIMIT 3")
	ArrayList<EssayQs> selectBaseEssay();
	
	/**
	 * 取出逻辑单选
	 * @return
	 */
	@Select("SELECT * FROM exam_basesingle ORDER BY rand() LIMIT 20")
	@Results({
		@Result(column="BaseSingleTitle",property="baseSingleTitle"),
		@Result(column="BaseSingleA",property="baseSingleA"),
		@Result(column="BaseSingleB",property="baseSingleB"),
		@Result(column="BaseSingleC",property="baseSingleC"),
		@Result(column="BaseSingleD",property="baseSingleD"),
		@Result(column="BaseSingleAS",property="baseSingleAS"),
		@Result(column="eid",property="eid")
	})
	ArrayList<BaseQs> selectBaseQs();
	
	/**
	 * 取出专业简答
	 * @param post
	 * @return
	 */
	@Select("SELECT eTitle,essayId FROM essay WHERE post = #{post} ORDER BY rand() LIMIT 3")
	ArrayList<ProEssayQs> selectProEssay(@Param("post")String post);
	
	/**
	 * 取出必答题
	 * @param post
	 * @return
	 */
	@Select( "SELECT rid,title FROM required_info WHERE post = #{post}")
	RequiredQs getReQs(@Param("post")String post);

	
	/**
	 * 更新考试状态
	 * @param username
	 */
	@Update("UPDATE user_interviewer SET status = 't' WHERE account= #{username}")
	void modifyStatus(String username);
}
