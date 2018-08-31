package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.BaseEssay;

public interface GetAllBaseEssayDao {
	
	@Select("SELECT * FROM baseessay LIMIT #{index},4")
	ArrayList<BaseEssay> getBaseEssay(@Param("index")int index);
	
	@Select("SELECT count(*) FROM baseessay")
	int getCounts();

}
