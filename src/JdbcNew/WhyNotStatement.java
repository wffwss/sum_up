package JdbcNew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WhyNotStatement {

	public static void main(String[] args) {
		// 第一步和第二步
		Connection connection = JDBCUtils.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// 第三步：操作数据库
			statement = connection.createStatement();
			// 查询是否存在用户名为a，密码为b的用户
			//数据库注入
			/*resultSet = statement
					.executeQuery("SELECT * FROM USER WHERE name = 'wff' AND PASSWORD = 'wffa' OR (1=1);");
			if (resultSet.next()) {
				System.out.println("用户存在");
				String name = resultSet.getString(1);
				String password = resultSet.getString(2);
				System.out.println(name + "-->" + password);
			} else {
				System.out.println("用户不存在");
			}*/
			//解决sql注入问题：先根据用户提供的用户名，到数据库中取出对应的密码，再和用户给出的密码进行判断
			resultSet = statement.executeQuery("SELECT PASS FROM USER WHERE name = 'wff'");
			while (resultSet.next()) {
				String password = resultSet.getString(1);
				if (password.equals("'wffa' or (1=1)")) {
					System.out.println("用户存在，密码是：" + password);
				} else {
					System.out.println("密码错误");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//第四步，关闭数据库连接
		JDBCUtils.close(resultSet, statement, connection);

	}

}
