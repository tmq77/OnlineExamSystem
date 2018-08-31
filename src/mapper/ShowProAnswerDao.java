package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.GetAnswerData;

public interface ShowProAnswerDao {
	
	@Select("SELECT eTitle,eRight,answer FROM essay INNER JOIN proessay "
			+ "ON essay.essayId = proessay.essayId AND proessay.account = #{account}")
	ArrayList<GetAnswerData> showProAns(@Param("account")String account);

}
