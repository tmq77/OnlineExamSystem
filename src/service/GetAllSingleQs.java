package service;

import java.util.ArrayList;

/**
 * 获取所有的单选题
 * @author taominqi
 *
 */
public interface GetAllSingleQs {
	
	ArrayList<model.BaseQs> getSingleQsAll(int index);
	
	int getCounts();

}
