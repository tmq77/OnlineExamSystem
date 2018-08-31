package mapper;

import org.apache.ibatis.annotations.Delete;

public interface DeleteStaffDao {
	
	@Delete("DELETE FROM staff WHERE phone = #{username}")
	int deleteStaff(String username);
	
	@Delete("DELETE FROM printsingle_info WHERE account = #{username}")
	int deletePrintSingle(String username);
	
	@Delete("DELETE FROM printpro_info WHERE account = #{username}")
	int deletePrintProExam(String username);
	
	@Delete("DELETE FROM printbase_info WHERE account = #{username}")
	int deletePrintBaseExam(String username);
	
	@Delete("DELETE FROM printrequired_info WHERE account = #{username}")
	int deletePrintAllExam(String username);
	
	@Delete("DELETE FROM printaudio_info WHERE account = #{username}")
	int deletePrintAudioExam(String username);

}
