package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.GetAnswerData;

public interface ShowBaseAnswerDao {
	
	@Select("SELECT essayTitle AS eTitle,essayRight AS eRight,bAnswer AS answer FROM baseessay INNER JOIN ansessay"
			+ " ON essayId = bEssayId AND ansessay.account = #{account}")
	ArrayList<GetAnswerData> showBaseAns(@Param("account")String account);

}
