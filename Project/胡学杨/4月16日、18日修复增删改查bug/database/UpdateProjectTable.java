package edu.hxy.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.hxy.string.TimeNow;

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
		UpdateMainPageTable.update();//更新主页
		projectTime(projectId);
	}
	//修改项目
	public static void changeProject(int projectId,String projectName,String projectDescription) throws ClassNotFoundException, SQLException {		
		String sql = "update projectManage set projectName=?,projectDescription=? where projectId="+projectId;
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, projectName);
		pstmt.setString(2, projectDescription);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("修改项目成功");
		}
		Content.close(conn,pstmt,null);	
		projectTime(projectId);
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
		UpdateMainPageTable.update();//更新主页	
		addOldProject(projectId);
	}
	//设置时间
	public static void projectTime(int projectId) throws SQLException, ClassNotFoundException {
		String sql = "update projectManage set updateTime=? where projectId="+projectId;
		conn = Content.connect(conn);
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1,TimeNow.getTime());
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("设置项目时间成功");
		}
		else {
			System.out.println("修改项目时间失败");
		}
		Content.close(conn,pstmt,null);	
	}
	//增加旧工程
	public static void addOldProject(int oldProjectId) throws ClassNotFoundException, SQLException {
		String sql = "insert into oldProject(oldProjectId) values(?)";
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, oldProjectId);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("增加旧工程成功");
		}
		else {
			System.out.println("增加旧工程失败");
		}
		Content.close(conn,pstmt,null);	
	}
}
