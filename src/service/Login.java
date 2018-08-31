package service;

/**
 * 服务类接口
 * 判断登录的人员身份
 * @author Administrator
 *
 */
public interface Login {
	
	public int judge(String role,String username,String password);

}
