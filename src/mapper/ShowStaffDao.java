package mapper;

import java.util.ArrayList;

import model.Staff;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ShowStaffDao {
	@Select("SELECT count(*) FROM staff")
	int showTotalPage();

	@Select("SELECT name,phone,"
			+ "post,email FROM staff ORDER BY name LIMIT #{pageNo},6")
	ArrayList<Staff> getAllStaff(@Param("pageNo")int pageNo);
}
