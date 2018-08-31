package service;

/**
 * 超级管理员的验证登陆接口
 * @author taominqi
 *
 */
public interface RootLogin {

	public int loginJudge(String username,String password);
}
