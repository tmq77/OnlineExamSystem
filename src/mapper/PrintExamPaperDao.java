package mapper;

import java.util.ArrayList;

import model.GetAnswerData;
import model.GetRequiredAnswer;
import model.PaperBaseQs;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PrintExamPaperDao {
	
	/**
	 * 打印单选题
	 * @param username
	 * @return
	 */
	@Select("SELECT * FROM printsingle_info WHERE account = #{username}")
	ArrayList<PaperBaseQs> getSingleQs(@Param("username")String username);
	
	/**
	 * 打印专业简答
	 * @param username
	 * @return
	 */
	@Select("SELECT protitle AS eTitle,proanswer AS eRight,useranswer AS answer FROM printpro_info WHERE account = #{username}")
	ArrayList<GetAnswerData> getProExam(@Param("username")String username);

	
	/**
	 * 打印基础简答
	 * @param username
	 * @return
	 */
	@Select("SELECT basetitle AS eTitle,baseanswer AS eRight,useranswer AS answer FROM printbase_info WHERE account = #{username}")
	ArrayList<GetAnswerData> getBaseExam(@Param("username")String username);
	
	
	/**
	 * 打印综合题
	 * @param username
	 * @return
	 */
	@Select("SELECT videoanswer AS vanswer,alltitle AS title,allanswer AS rright,useranswer AS ranswer,aRight AS vright FROM printrequired_info INNER JOIN printaudio_info INNER JOIN audioright_info ON printrequired_info.account = #{username} AND printaudio_info.account = printrequired_info.account")
	GetRequiredAnswer getRequiredExam(@Param("username")String username);
}
