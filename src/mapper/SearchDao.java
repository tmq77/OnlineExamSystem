package mapper;

import java.util.ArrayList;

import model.BaseEssay;
import model.BaseQs;
import model.ModifyRequiredQs;
import model.ProEssay;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface SearchDao {

	@Select("SELECT * FROM exam_basesingle WHERE BaseSingleTitle LIKE #{str}")
	@Results({
		@Result(column="BaseSingleTitle",property="baseSingleTitle"),
		@Result(column="BaseSingleA",property="baseSingleA"),
		@Result(column="BaseSingleB",property="baseSingleB"),
		@Result(column="BaseSingleC",property="baseSingleC"),
		@Result(column="BaseSingleD",property="baseSingleD"),
		@Result(column="BaseSingleAS",property="baseSingleAS"),
		@Result(column="eid",property="eid")
	})
	ArrayList<BaseQs> getSingleSearch(@Param("str")String str);
	
	@Select("SELECT * FROM baseessay WHERE essayTitle LIKE #{str}")
	ArrayList<BaseEssay> getBaseEssaySearch(@Param("str")String str);
	
	/**
	 * 专业简答
	 * @param post
	 * @param str
	 * @return
	 */
	@Select("SELECT * FROM essay WHERE post = #{post} AND eTitle LIKE #{str}")
	ArrayList<ProEssay> getProEssaySearch(@Param("post")String post,@Param("str")String str);
	
	
	/**
	 * @param post
	 * @param str
	 * @return
	 */
	@Select("SELECT * FROM required_info WHERE post = #{post} AND title LIKE #{str}")
	ArrayList<ModifyRequiredQs> getRequiredSearch(@Param("post")String post,@Param("str")String str);
}
