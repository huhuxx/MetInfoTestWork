package edu.hxy.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateImplementTable {
	static Connection conn= null;
	//增加接口
	public static void addImplement(int implementId,String implementName,String environment,String requestStyle,String dataStyle,String requestUrl) throws ClassNotFoundException, SQLException {
		String sql = "insert into implementManage(implementId,implementName,environment,requestStyle,dataStyle,requestUrl) values(?,?,?,?,?,?)";
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, implementId);
		pstmt.setString(2, implementName);
		pstmt.setString(3, environment);
		pstmt.setString(4, requestStyle);
		pstmt.setString(5, dataStyle);
		pstmt.setString(6, requestUrl);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("插入成功");
		}
		Content.close(conn,pstmt,null);	
	}
	//删除接口
	public static void deleteImplement(int implementId) throws ClassNotFoundException, SQLException {
		String sql = "delete from implementManage where implementId="+implementId;
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
