package Handler;

/**
 * sql语句类,提供各种sql语句
 * @author bingsoft
 *
 */
public class SqlString {

	/**
	 * 查询应试者账号密码
	 * @return
	 */
	public static String getLoginSql() {
		return "SELECT account,pass FROM user_interviewer WHERE account = ?";
	}

	/**
	 * 获取管理员信息
	 * @return
	 */
	public static String getAdminLoginSql() {
		return "SELECT account,pass FROM user_admin WHERE account = ?";
	}

	/**
	 * 添加人员信息
	 * @return
	 */
	public static String getAddSql() { 
		return "INSERT INTO user_interviewer(name,account,pass,post) VALUES(?,?,?,?)"; 
	}
	/**
	 * 查看人员信息
	 * @return
	 */
	public static String getPreSql() {
		return "SELECT name,account,pass,post,status FROM user_interviewer";
	}
	
	/**
	 * 删除人员信息
	 * @return
	 */
	public static String getDeleteSql() {
		return "DELETE FROM user_interviewer WHERE account = ?";
	}
	
	/**
	 * 更新人员信息
	 * @return
	 */
	public static String getUpdateSql() {
		return "UPDATE user_interviewer SET name = ?,account = ?,pass = ?,post = ? WHERE uid = ?";
	}
	public static String getAddEqQssql(){//情商------------------暂留
		return "INSERT INTO exam_eq(content,optionA,optionB,optionC) VALUES(?,?,?,?)";
	}
	/**
	 * 基础逻辑单选
	 * @return
	 */
	public static String getAddBaseSingle(){
		return "INSERT INTO exam_basesingle(BaseSingleTitle,BaseSingleA,BaseSingleB,BaseSingleC,BaseSingleD,BaseSingleAS) VALUES(?,?,?,?,?,?)";
	}
	/**
	 * 基础逻辑问答
	 * @return
	 */
	public static String getAddBaseEssay(){
		return "INSERT INTO baseessay(essayTitle,essayRight) VALUES(?,?)";
	}
	/**
	 * 添加专业单选
	 * @return
	 */
	public static String getAddSingle(){
		return "INSERT INTO Single(sTitle,sOptionA,sOptionB,sOptionC,sOptionD,sOptionR,post) VALUES(?,?,?,?,?,?,?)";
	}
	/**
	 * 添加专业问答
	 * @return
	 */
	public static String getAddEssay(){//添加专业问答
		return "INSERT INTO essay(eTitle,eRight,post) VALUES(?,?,?)";
	}
	/**
	 * 取出专业单选
	 * @return
	 */
	public static String getSelectSingleSql() { //专业单选
		return "SELECT * FROM single WHERE post = ? ORDER BY rand() LIMIT 20"; //随机取出20道题目
	}
	/**
	 * 取出逻辑单选
	 * @return
	 */
	public static String getSelectBaseSingleSql() {
		return "SELECT * FROM exam_basesingle ORDER BY rand() LIMIT 20"; //随机取出20道逻辑单选题
	}
	/**
	 * 取出专业问答
	 * @return
	 */
	public static String getSelectEssay(){
		return "SELECT * FROM essay WHERE post = ? ORDER BY rand() LIMIT 5";
	}
	
	/**
	 * 专业简答题号，专业简答答案存入表中
	 * @return
	 */
	public static String getSaveAnswer(){
		return "INSERT INTO proessay(account,essayId,answer) VALUES(?,?,?)";
	}
	/**
	 * 取出逻辑问答
	 * @return
	 */
	public static String getSelectBaseEssay(){//随机取出5道逻辑问答
		return "SELECT * FROM baseessay ORDER BY rand() LIMIT 5";
	}
	
	/**
	 * 基础简答题号、基础简答答案存入表中
	 * @return
	 */
	public static String getSaveBaseAnswer(){
		return "INSERT INTO ansessay(account,bEssayId,bAnswer) VALUES(?,?,?)";
	}
	
	/**
	 * 基础单选、专业单选分数存入数据库
	 * @return
	 */
	public static String getSaveSingleScore(){
		return "INSERT INTO score(id,name,baseSingle) VALUES(?,?,?)";
	}
	
	/**
	 * 将考试完成的人员的状态更新为1（已考试）
	 * @return
	 */
	public static String getChangeStatus(){
		return "UPDATE user_interviewer SET status = 't' WHERE account= ?";
	}
	
	/**
	 * 取出单选分数以及简答答案。
	 * @return
	 */
	public static String getScore(String flag){
		if(flag.equals("score")){
		//姓名，职位，基础单选分数，专业单选分数.
		return "SELECT user_interviewer.name,user_interviewer.account,user_interviewer.post,basesingle,prosingle FROM user_interviewer,score WHERE user_interviewer.account = score.name";
		}else if(flag.equals("proessay")){
			//取出专业简答问题以及答案
			return "SELECT eTitle,eRight,answer FROM essay,proessay WHERE  essay.essayId = proessay.essayId AND proessay.account = ?";

		}else if(flag.equals("baseessay")){
			//取出基础简答问题以及答案
			return "SELECT essayTitle,essayRight,bAnswer FROM baseessay,ansessay WHERE essayId = bEssayId AND ansessay.account = ?";
		}else{
			return null;
		}
	}
	
}
