package JDBCconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	
	private static String url="jdbc:mysql://localhost:3306/wff0316_homework";
	private static String userString="root";
	private static String passwordString="root";
	private static Statement statement=null;//操作数据库的接口 
	private static ResultSet resultSet=null;//表示数据库结果集的数据表，一般针对executeQuery(sql)即查询
	private static ResultSetMetaData rsd=null;//获取此 ResultSet 对象的列的编号、类型和属性。 
	
	public static void update(String sql,int i) throws SQLException{
		statement.executeUpdate(sql);
		switch (i) {
		case 1:
			System.out.println("插入数据成功");
			break;
		case 2:
			System.out.println("更新数据成功");
			break;
		case 3:
			System.out.println("删除数据成功");
			break;

		default:
			break;
		}
		
	}
	
	public static void select(String sql) throws SQLException{
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			String nameString=resultSet.getString(1);
			String passString=resultSet.getString("pass");
			System.out.println(nameString+":"+passString);
		}
		rsd=resultSet.getMetaData();
		//获取表一共有多少列
		int count=rsd.getColumnCount();
		System.out.println("列数："+count);
		//获取每一列的信息
		for (int i = 1; i <=count; i++) {
			String name=rsd.getColumnName(i);
			String type=rsd.getColumnTypeName(i);
			System.out.println(name+"---->"+type);
		}
	}
	
	public static void main(String[] args) {
		
		//第一步：加载数据库驱动，设置jdbc jar包路径，现在已经不需要显示加载jdbc驱动，系统已经配置好
		//第二步：获取连接数据库对象
		//地址：jdbc:mysql://数据库所在服务器地址:3306/数据库名称		
		//数据库连接对象
		Connection connection = null;	
		try {
			connection= DriverManager.getConnection(url,userString,passwordString);
			System.out.println("数据库连接成功");
			//第三步：操作数据库
			statement=connection.createStatement();
			String sql="insert into user(name,pass) values('张风格','345')";
			String sql2="update user set pass='hello' where name='wff'";
			String sql3="delete from user where name='张风格'";
			String sql4="select * from user";
			//1表示插入数据    2表示更新数据   3表示删除数据
//		    update(sql,1);//插入数据
//			update(sql2,2);//更新数据
//			update(sql3,3);//删除数据
			select(sql4);
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//第四步：关闭数据库连接
			try {
				if(resultSet!=null){
					resultSet.close();
				}
				if(statement!=null){
					statement.close();
				}
				if(connection!=null){
					connection.close();
				}		
			} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();	
			}
		}
	}

}
