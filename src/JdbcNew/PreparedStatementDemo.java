package JdbcNew;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo {
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;

	private static void adjustUser() {
		try {
			connection = JDBCUtils.getConnection();
			// 第三步：操作数据库
			String sql="SELECT * FROM USER WHERE name = ? AND pass = ?;";
			statement = connection.prepareStatement(sql);
			// 查询是否存在用户名为a，密码为b的用户
			// 数据库注入?如果是静态数据，那么不能解决，如果是动态数据呢
			statement.setString(1, "wff");
			//statement.setString(2, "wff or (1=1)");这样就不对
			statement.setString(2, "wff2");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				System.out.println("用户存在");
				String name = resultSet.getString(1);
				String password = resultSet.getString(2);
				System.out.println(name + "-->" + password);
			} else {
				System.out.println("用户不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 第四步，关闭数据库连接
			JDBCUtils.close(resultSet, statement, connection);
		}
	}

	// 增
	private static void addtUser() {
		try {
			connection = JDBCUtils.getConnection();
			// 第三步：操作数据库
			String sql = "insert into user(name,pass) values(?,?)";
			statement = connection.prepareStatement(sql);
			// 查询是否存在用户名为a，密码为b的用户
			// 数据库注入?如果是静态数据（比如直接写入d），那么不能解决，如果是动态数据呢（就是数据先用？代替）,则可以解决
			// 那么statement是否可以解决动态呢，不可以，因为statement只可以处理静态数据
			statement.setString(1, "张风格");//1指第一个问号
			statement.setString(2, "345");
			int column = statement.executeUpdate();
			System.out.println("数据库受影响行数：" + column);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 第四步，关闭数据库连接
			JDBCUtils.close(resultSet, statement, connection);
		}
	}

	// 改
	private static void modifyUser() {
		try {
			connection = JDBCUtils.getConnection();
			// 第三步：操作数据库
			String sql="update user set pass=? where name=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "张风格2");
			statement.setString(2, "张风格");
			int column = statement.executeUpdate();
			System.out.println("数据库受影响行数：" + column);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 第四步，关闭数据库连接
			JDBCUtils.close(resultSet, statement, connection);
		}
	}

	// 删除
	private static void deleteUser() {
		try {
			connection = JDBCUtils.getConnection();
			// 第三步：操作数据库
			String sql="delete from  user where name=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "张风格");
			int column = statement.executeUpdate();
			System.out.println("数据库受影响行数：" + column);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 第四步，关闭数据库连接
			JDBCUtils.close(resultSet, statement, connection);
		}
	}

	public static void main(String[] args) {
		// adjustUser();
		// addtUser();
//		modifyUser();
		deleteUser();
	}

}
