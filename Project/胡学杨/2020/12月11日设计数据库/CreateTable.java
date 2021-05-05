package edu.hxy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	static String driverStr="com.mysql.cj.jdbc.Driver";
	static String connUrl = "jdbc:mysql://localhost:3306/implementTest?useSSL=true&serverTimezone=UTC";
	
	public static void createTable(String sql) throws SQLException, ClassNotFoundException {
//		1、加载驱动
		Class.forName(driverStr);
//		2、获取数据库的连接对象
		Connection conn=DriverManager.getConnection(connUrl,"root","12345678");
		if(!conn.isClosed()){
//			3、获取执行SQL语句的对象（Statement、PreparedStatement）
			Statement stmt=conn.createStatement();
//			4、执行SQL
			stmt.execute(sql);
		}
//		5、关闭数据库
		conn.close();	
		System.out.println("创建数据库成功");
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
////用例管理数据库
//		String sql = "create table caseManage"+
//					 "(id int(11) primary key,"+
//					 "name varchar(100),"+
//					 "project varchar(100),"+
//					 "environment varchar(100),"+
//					 "implement varchar(100))";
////接口管理数据库
//		String sql = "create table implementManage"+
//					 "(id int(11) primary key,"+
//					 "name varchar(100),"+
//					 "project varchar(100),"+
//					 "environment varchar(100),"+
//					 "requestStyle varchar(100),"+
//					 "dataStyle varchar(100),"+
//					 "requestURL varchar(200))";
////接口管理数据库
//			String sql = "create table implementManage"+
//						 "(id int(11) primary key,"+
//						 "name varchar(100),"+
//						 "project varchar(100),"+
//						 "environment varchar(100),"+
//						 "requestStyle varchar(100),"+
//						 "dataStyle varchar(100),"+
//						 "requestURL varchar(200))";
////项目管理数据库
//			String sql = "create table projectManage"+
//						 "(id int(11) primary key,"+
//						 "name varchar(100),"+
//						 "description varchar(100),"+
//						 "date varchar(100),"+
//						 "username varchar(100))";	
	//环境管理数据库
		String sql = "create table projectManage"+
					 "(projectId int(11),"+
					 "projectName varchar(100) primary key,"+
					 "projectDescription varchar(100),"+
					 "updateTime varchar(100),"+
					 "username varchar(100))";
		String sql1 = "create table environmentManage"+
				 "(environmentId int(11),"+
				 "environmentName varchar(100) primary key,"+
				 "swaggerNumber int(11),"+
				 "url varchar(100),"+
				 "project varchar(100),"+
				 "updateTime varchar(100),"+
				 "username varchar(100),"+
				 "foreign key(project) references projectManage(projectName))";	
		String sql2 = "create table implementManage"+
				 "(implementId int(11),"+
				 "implementName varchar(100) primary key,"+
				 "environment varchar(100),"+
				 "requestStyle varchar(100) CHECK (requestStyle in ( 'POST','GET')),"+
				 "dataStyle varchar(100) CHECK (dataStyle in ( 'Params','JSON')),"+
				 "requestUrl varchar(100),"+
				 "foreign key(environment) references environmentManage(environmentName))";	
		createTable(sql2);
	}
}	