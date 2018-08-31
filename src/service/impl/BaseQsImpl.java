package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mapper.AddBaseQsDao;
import model.SaveBaseEssay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Handler.SqlString;
import service.BaseQs;

/**
 * 存储基础题试题
 * @author taominqi
 *
 */
@Transactional
@Service("baseQsImpl")
public class BaseQsImpl implements BaseQs{

	
	@Autowired
	private AddBaseQsDao addBaseQsDao;
	

	public int addBaseQs(String Qs_type, String eq_Title, String eq_Single_A, String eq_Single_B, String eq_Single_C,
			String BaseSingleTitle, String BaseSingleA, String BaseSingleB, String BaseSingleC, String BaseSingleD,
			String BasesingleAS, String essayTitle, String essayRight)throws DataAccessException {
		
		PreparedStatement pstmt = null;
		Connection conn = ConnectionUtil.getConnection();
		
		if("1".equals(Qs_type)){//暂时不用----录入情商题
		try {
			
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SqlString.getAddEqQssql());
			pstmt.setString(1, eq_Title.trim());
			pstmt.setString(2, eq_Single_A);
			pstmt.setString(3, eq_Single_B);
			pstmt.setString(4, eq_Single_C);
			pstmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
			 	conn.rollback();
			} catch (SQLException e1) {
				System.out.println("数据插入失败");
				e1.printStackTrace();
				return -1;
			}
			System.out.println("捕捉到数据库异常");
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if(pstmt!=null){
				pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}else if("2".equals(Qs_type)){
	model.BaseQs baseQs = new model.BaseQs(BaseSingleTitle.trim(), BaseSingleA, BaseSingleB, BaseSingleC, BaseSingleD, BasesingleAS);
	int flag=addBaseQsDao.addBaseSingle(baseQs);	
	if(flag==0){
		return -1;
	}
	return 1;
		
	}else if("3".equals(Qs_type)){
		SaveBaseEssay saveBaseEssay = new SaveBaseEssay(essayTitle, essayRight);
		addBaseQsDao.addBaseEssay(saveBaseEssay);
		return 1;	
	
	}
		return -1;
	}
}
