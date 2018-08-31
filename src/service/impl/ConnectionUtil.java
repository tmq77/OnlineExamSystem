package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;



@Component("connection")
public class ConnectionUtil{
	
	private static ComboPooledDataSource ds;

	@Resource(name="dataSource")
	public void setDs(ComboPooledDataSource ds){
		ConnectionUtil.ds=ds;
	}
	
	public static Connection getConnection() {
		
			try {
				System.out.println("取出连接池中的连接");
				return ds.getConnection();
			} catch (SQLException e) {
				return null;
			}
		
	}

}
