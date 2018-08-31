package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import model.GetAnswerData;
import model.GetRequiredAnswer;
import model.PaperBaseQs;

public interface PrintPaperDao {
	
	/**
	 * 通过前的验证，一般不需要这步，但是为了安全起见，防止已经通过的人员再次被点击通过而造成的数据混乱
	 * @param username
	 * @return
	 */
	@Select("SELECT count(*) FROM printrequired_info WHERE account = #{username}")
	int insertCheck(@Param("username")String username);
	
	/**
	 * 获取当前人员的所有单选题目以及答案
	 * @param username
	 * @return
	 */
	@Select("SELECT * FROM printsingle_temp WHERE account = #{username}")
	ArrayList<PaperBaseQs> printSingleQs(@Param("username")String username);

	/**
	 * 获取当前人员所有的专业简答题目以及答案
	 * @param username
	 * @return
	 */
	@Select("SELECT eTitle,eRight,answer FROM essay INNER JOIN proessay "
			+ "ON essay.essayId = proessay.essayId AND proessay.account = #{username}")
	ArrayList<GetAnswerData> printProExam(@Param("username")String username);
	
	/**
	 * 获取当前人员所有的基础简答题目及答案
	 * @param username
	 * @return
	 */
	@Select("SELECT essayTitle AS eTitle,essayRight AS eRight,bAnswer AS answer FROM baseessay INNER JOIN ansessay"
			+ " ON essayId = bEssayId AND ansessay.account = #{username}")
	ArrayList<GetAnswerData> printBaseExam(@Param("username")String username);


	/**
	 * 获取当前人员的所有的综合题及答案
	 * @param username
	 * @return
	 */
	@Select("SELECT title,rright,aRight,ranswer,vanswer FROM required_info "
			+ "INNER JOIN requiredanswer INNER JOIN audioans_info INNER JOIN audioright_info ON required_info.rid = requiredanswer.rid AND requiredanswer.account = #{username} AND audioans_info.account = requiredanswer.account")
	GetRequiredAnswer printRequiredExam(@Param("username")String username);
	
	
	/***************插入到打印表*******************/
	/**
	 * 单选插入打印表
	 * @param singleQs
	 * @return
	 */
	@Insert("INSERT INTO printsingle_info "
			+ "VALUES(#{uuid},#{account},#{singletitle},#{singleA},#{singleB},#{singleC},#{singleD},#{singleAs},#{singleUs})")
	int insertPrintSingle(PaperBaseQs singleQs);
	
	/**
	 * 专业简答插入
	 * @param uuid
	 * @param username
	 * @param protitle
	 * @param proanswer
	 * @param useranswer
	 * @return
	 */
	@Insert("INSERT INTO printpro_info VALUES(#{uuid},#{username},#{protitle},#{proanswer},#{useranswer})")
	int insertPrintProExam(@Param("uuid")String uuid,@Param("username")String username,@Param("protitle")String protitle,@Param("proanswer")String proanswer,@Param("useranswer")String useranswer);
	
	/**
	 * 基础简答插入
	 * @param uuid
	 * @param username
	 * @param basetitle
	 * @param baseanswer
	 * @param useranswer
	 * @return
	 */
	@Insert("INSERT INTO printbase_info VALUES(#{uuid},#{username},#{basetitle},#{baseanswer},#{useranswer})")
	int insertPrintBaseExam(@Param("uuid")String uuid,@Param("username")String username,@Param("basetitle")String basetitle,@Param("baseanswer")String baseanswer,@Param("useranswer")String useranswer);
	
	/**
	 * 综合题插入
	 * @param uuid
	 * @param username
	 * @param videoanswer
	 * @param alltitle
	 * @param allanswer
	 * @param useranswer
	 * @return
	 */
	@Insert("INSERT INTO printrequired_info VALUES(#{uuid},#{username},#{alltitle},#{allanswer},#{useranswer})")
	int insertPrintRequiredExam(@Param("uuid")String uuid,@Param("username")String username,@Param("alltitle")String alltitle,@Param("allanswer")String allanswer,@Param("useranswer")String useranswer);
	//录音题插入
	@Insert("INSERT INTO printaudio_info VALUES(#{uuid},#{videoanswer},#{username})")
	int insertPrintAudioExam(@Param("uuid")String uuid,@Param("videoanswer")String videoanswer,@Param("username")String username);
}
