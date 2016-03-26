package JdbcNew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC工具类，封装了JDBC共有的代码
public class JDBCUtils {
	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/wff0316_homework";
	private static String user = "root";
	private static String password = "root";
	//获取数据库连接
	public static Connection getConnection(){
		//第一步：加载数据库驱动
		//第二步：获取连接
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	//关闭数据库连接
	public static void close(ResultSet resultSet,Statement statement,Connection connection){
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
