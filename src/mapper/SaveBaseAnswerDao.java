package mapper;

import model.InsertBaseAnswer;

import org.apache.ibatis.annotations.Insert;

public interface SaveBaseAnswerDao {

	@Insert("INSERT INTO ansessay(baseId,account,bEssayId,bAnswer) VALUES(#{baseId},#{account},#{bEssayId},#{bAnswer})")
	public int saveBaseAnswer(InsertBaseAnswer insertBaseAnswer);
}
