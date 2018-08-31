package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.ExamData;

public interface ShowScoreDao {
	
	@Select("SELECT user_interviewer.name,user_interviewer.account,"
			+ "user_interviewer.post,baseSingle,user_interviewer.email FROM user_interviewer INNER JOIN score ON"
			+ " user_interviewer.account = score.name ORDER BY baseSingle DESC LIMIT #{pageNo},6")
	ArrayList<ExamData> getAllScore(@Param("pageNo")int pageNo);
	
	@Select("SELECT count(*) FROM score")
	int getTotalPage();



}
