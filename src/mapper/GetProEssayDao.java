package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.ProEssayQs;

/**
 * 获取专业简答题目--出题
 * @author taominqi
 *
 */
public interface GetProEssayDao {

	@Select("SELECT eTitle,essayId FROM essay WHERE post = #{post} ORDER BY rand() LIMIT 3")
	ArrayList<ProEssayQs> selectProEssay(@Param("post")String post);
}
