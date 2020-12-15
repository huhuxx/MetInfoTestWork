package edu.hxy.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEnvironmentTable {
	static Connection conn= null;
	//增加环境
	public static void addEnvironment(int environmentId,String environmentName,String url,String project) throws ClassNotFoundException, SQLException {
		String sql = "insert into environmentManage(environmentId,environmentName,url,project) values(?,?,?,?)";
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, environmentId);
		pstmt.setString(2, environmentName);
		pstmt.setString(3, url);
		pstmt.setString(4, project);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("插入成功");
		}
		Content.close(conn,pstmt,null);	
	}
	//删除环境
	public static void deleteEnvironment(int environmentId) throws ClassNotFoundException, SQLException {
		String sql = "delete from environmentManage where environmentId="+environmentId;
		conn = Content.connect(conn);
		conn.prepareStatement(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		if(result > 0) {
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}
		Content.close(conn,pstmt,null);	
	}
}
