package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.GetRequiredAnswer;

public interface ShowRequiredAnswerDao {

	@Select("SELECT title,rright,aRight,ranswer,vanswer FROM required_info INNER JOIN requiredanswer"
			+ " INNER JOIN audioans_info INNER JOIN audioright_info ON required_info.rid = requiredanswer.rid AND requiredanswer.account = #{account} AND audioans_info.account = requiredanswer.account")
	GetRequiredAnswer showReqAns(@Param("account")String account);
}
