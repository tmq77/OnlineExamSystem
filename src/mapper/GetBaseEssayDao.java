package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import model.EssayQs;

public interface GetBaseEssayDao {

	@Select("SELECT essayTitle,essayId FROM baseessay ORDER BY rand() LIMIT 3")
	ArrayList<EssayQs> selectBaseEssay();
}
