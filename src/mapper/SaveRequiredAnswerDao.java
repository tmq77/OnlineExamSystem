package mapper;

import model.InsertRequiredAnswer;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface SaveRequiredAnswerDao {
	
	@Insert("INSERT INTO requiredanswer(id,rid,ranswer,account) VALUES(#{id},#{rid},#{ranswer},#{account})")
	public int saveRequiredAnswer(InsertRequiredAnswer insertRequiredAnswer);

	@Insert("INSERT INTO audioans_info(vid,vanswer,account) VALUES(#{uuid},#{vanswer},#{account})")
	public int saveAudioAnswer(@Param("uuid")String uuid,@Param("vanswer")String vanswer,@Param("account")String account);
}
