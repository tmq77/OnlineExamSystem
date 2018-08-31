package service;

import org.springframework.dao.DataAccessException;

public interface BaseQs {
	public int addBaseQs(String Qs_type,String eq_Title,String eq_Single_A,String eq_Single_B,String eq_Single_C,String BaseSingleTitle,String BaseSingleA,String BaseSingleB,String BaseSingleC,String BaseSingleD,String BasesingleAS,String essayTitle,String essayRight)throws DataAccessException;

}
