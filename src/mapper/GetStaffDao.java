package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

/**
 * 面试人员信息插入
 * @author taominqi
 *
 */
public interface GetStaffDao {
	
	@Insert("INSERT INTO staff(pid,name,phone,post,email) VALUES(#{pid},#{name},#{phone},#{post},#{mail})")
	int insertStaff(@Param("pid")String pid,@Param("name")String name,@Param("phone")String phone,@Param("post")String post,@Param("mail")String mail)throws DataAccessException;
}
