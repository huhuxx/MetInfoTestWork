package edu.hxy.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProjectTable {
	static Connection conn= null;
	//增加项目
	public static void addProject(int projectId,String projectName,String projectDescription) throws ClassNotFoundException, SQLException {
		String sql = "insert into projectManage(projectId,projectName,projectDescription) values(?,?,?)";
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, projectId);
		pstmt.setString(2, projectName);
		pstmt.setString(3, projectDescription);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("插入成功");
		}
		Content.close(conn,pstmt,null);	
	}
	//删除项目
	public static void deleteProject(int projectId) throws ClassNotFoundException, SQLException {
		String sql = "delete from projectManage where projectId="+projectId;
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
