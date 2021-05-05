package edu.hxy.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.hxy.string.GetRowcount;

public class UpdateMainPageTable {
	static Connection conn= null;
	//更新主页信息
	public static void update() throws ClassNotFoundException, SQLException {
		int projectNumber=GetRowcount.getRowcount("projectManage");
		int implementNumber=GetRowcount.getRowcount("implementManage");
		int testNumber=GetRowcount.getRowcount("environmentManage");
		int memberNumber=GetRowcount.getRowcount("user");
		String sql = "update mainPage set projectNumber=?,implementNumber=?,testNumber=?,memberNumber=?";
		conn = Content.connect(conn);
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1,projectNumber);
		pstmt.setInt(2,implementNumber);
		pstmt.setInt(3,testNumber);
		pstmt.setInt(4,memberNumber);
		
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("更新成功");
		}
		Content.close(conn,pstmt,null);	
	}
}
