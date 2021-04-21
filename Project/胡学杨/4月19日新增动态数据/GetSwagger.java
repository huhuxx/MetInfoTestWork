package edu.hxy.string;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.hxy.database.UpdateImplementTable;

public class GetSwagger {
	public static void setSwagger() throws ClassNotFoundException, SQLException {
		String driverStr="com.mysql.cj.jdbc.Driver";
		String connUrl = "jdbc:mysql://localhost:3306/implementTest?useSSL=true&serverTimezone=UTC";
		Class.forName(driverStr);
		Connection conn=DriverManager.getConnection(connUrl,"root","123456");
		Statement stmt=conn.createStatement();
		ResultSet rset = stmt.executeQuery("select environmentName from environmentManage");
		while(rset.next()) {
			System.out.println(rset.getString("environmentName"));
			UpdateImplementTable.setSwagger(rset.getString("environmentName"), getSwagger(rset.getString("environmentName")));
		}
	}
	
	public static int getSwagger(String environmentName) throws ClassNotFoundException, SQLException {	
		String driverStr="com.mysql.cj.jdbc.Driver";
		String connUrl = "jdbc:mysql://localhost:3306/implementTest?useSSL=true&serverTimezone=UTC";
		Class.forName(driverStr);
		Connection conn=DriverManager.getConnection(connUrl,"root","123456");
		Statement stmt=conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from implementManage where environment='"+environmentName+"'");
		int rowCount = 0;
		while(rset.next()) {
			rowCount++;
		}
		conn.close();
		return rowCount;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GetSwagger.setSwagger();
		String driverStr="com.mysql.cj.jdbc.Driver";
		String connUrl = "jdbc:mysql://localhost:3306/implementTest?useSSL=true&serverTimezone=UTC";
		String a = "asdasda";
		Class.forName(driverStr);
		Connection conn=DriverManager.getConnection(connUrl,"root","123456");
		Statement stmt=conn.createStatement();
		String sql = "update environmentManage set swaggerNumber=? where environmentName ='"+"asdasda"+"'";
		ResultSet rset = stmt.executeQuery(sql);
//		int rowCount = 0;
//		while(rset.next()) {
//			rowCount++;
//		}
		conn.close();	
//		System.out.println(rowCount);
//		String sql = "update environmentManage set swaggerNumber=? where environmentName ='"+environmentName+"'";
//		System.out.println(getSwagger("asdasda"));
	}
}
