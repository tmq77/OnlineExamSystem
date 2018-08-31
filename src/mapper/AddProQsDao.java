package mapper;

import model.SaveProEssay;
import model.SingleQs;

import org.apache.ibatis.annotations.Insert;
import org.springframework.dao.DataAccessException;

public interface AddProQsDao {
	@Insert("INSERT INTO Single(sTitle,sOptionA,sOptionB,sOptionC,sOptionD,sOptionR,post) VALUES(#{sTitle},#{sOptionA},#{sOptionB},#{sOptionC},#{sOptionD},#{sOptionR},#{post})")
	int addSingle(SingleQs singleQs)throws DataAccessException;
	
	@Insert("INSERT INTO essay(eTitle,eRight,post) VALUES(#{eTitle},#{eRight},#{post})")
	int addEssay(SaveProEssay saveProEssay)throws DataAccessException;

}
