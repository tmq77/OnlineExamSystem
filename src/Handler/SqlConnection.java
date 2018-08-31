package Handler;

import java.sql.*;

/**
 * 数据库连接,后期准备换成C3P0连接池
 * @author taomi_000
 *
 */
public class SqlConnection {
 Connection connection;
	public  Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库加载失败");
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexamsystem", "root", "12345");// 使用指定字符集，防止乱码以及不显示问题
																										// connection
																										// =
																										// DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gb2312",
																										// "root",
																										// "");
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return connection;
	}
	
}
