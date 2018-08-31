package service;

import java.util.ArrayList;

import org.springframework.dao.DataAccessException;

/**
 * 存储考生的单选题试卷
 * @author taomi_000
 *
 */
public interface SingleQsPaper {// ---------此服务层已经整合---弃用
	/**
	 * @param temp  存放考生答案的数组
	 * @param singleID 存放单选试题序号的数组
	 * @param username 考生的账号
	 * @return
	 */
	public int insertSingleQs(String[] temp,ArrayList<Integer> singleID,String username)throws DataAccessException;
}
