package mapper;

import model.InsertProAnswer;

import org.apache.ibatis.annotations.Insert;

/**
 * 保存专业题考试答案到数据库
 * @author taominqi
 *
 */
public interface SaveProAnswerDao {
	
	@Insert("INSERT INTO proessay(proId,account,essayId,answer) VALUES(#{proId},#{account},#{essayId},#{answer})")
	public int saveProAnswer(InsertProAnswer insertProAnswer);

}
