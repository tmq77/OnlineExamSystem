package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.ModifyStatusModel;

/**
 * 二次修改考试状态
 * @author taominqi
 *
 */
public interface ModifyStatusDao {
	
	@Select("SELECT account,status FROM user_interviewer ORDER BY status LIMIT #{pageNo},6")
	List<ModifyStatusModel> getModifyUser(@Param("pageNo")int pageNo);
	
	
	/**
	 * 获取当前人员的在考试分数表中的记录数，如果没有，就是中途退出
	 * @param username  账号
	 * @return
	 */
	@Select("SELECT count(*) FROM score WHERE name = #{username}")
	int getExamCount(@Param("username")String username);

	@Select("SELECT count(*) FROM user_interviewer")
	public int totalPage();
}
