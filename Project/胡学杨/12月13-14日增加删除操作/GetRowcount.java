package edu.hxy.string;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetRowcount {
	public static int getRowcount(String tableName) throws ClassNotFoundException, SQLException {	
		String driverStr="com.mysql.cj.jdbc.Driver";
		String connUrl = "jdbc:mysql://localhost:3306/implementTest?useSSL=true&serverTimezone=UTC";
		Class.forName(driverStr);
		Connection conn=DriverManager.getConnection(connUrl,"root","12345678");
		Statement stmt=conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from "+tableName);
		int rowCount = 0;
		while(rset.next()) {
			rowCount++;
		}
		conn.close();	
		return rowCount;
	}
}
