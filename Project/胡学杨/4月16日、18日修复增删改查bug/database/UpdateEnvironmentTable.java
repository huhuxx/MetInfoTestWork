package edu.hxy.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.hxy.string.GetRowcount;
import edu.hxy.string.GetSwagger;
import edu.hxy.string.TimeNow;


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
			System.out.println("增加环境成功");
		}
		else {
			System.out.println("增加环境失败");
		}
		Content.close(conn,pstmt,null);	
		environmentTime(environmentId);
	}
	//修改环境
	public static void changeEnvironment(int environmentId,String environmentName,String url,String project) throws ClassNotFoundException, SQLException {
		String sql = "update environmentManage set environmentName=?,url=?,project=? where environmentId ="+environmentId;
		conn = Content.connect(conn);
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1,environmentName);
		pstmt.setString(2,url);
		pstmt.setString(3,project);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("修改环境成功");
		}
		else {
			System.out.println("修改环境失败");
		}
		Content.close(conn,pstmt,null);	
		environmentTime(environmentId);
	}
	//删除环境
	public static void deleteEnvironment(int environmentId) throws ClassNotFoundException, SQLException {
		String sql = "delete from environmentManage where environmentId="+environmentId;
		conn = Content.connect(conn);
		conn.prepareStatement(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		if(result > 0) {
			System.out.println("删除环境成功");
		}
		else {
			System.out.println("删除环境失败");
		}
		Content.close(conn,pstmt,null);	
		addOldEnvironment(environmentId);
	}
	//swagger增加减少
	public static void swagger() throws ClassNotFoundException, SQLException {
		int implementNumber=GetRowcount.getRowcount("implementManage");
		conn = Content.connect(conn);
		String sql = "update environmentManage set swaggerNumber=?";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1,implementNumber);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("修改环境成功");
		}
		else {
			System.out.println("修改环境失败");
		}
		Content.close(conn,pstmt,null);	
	}
	//设置时间
	public static void environmentTime(int environmentId) throws SQLException, ClassNotFoundException {
		String sql = "update environmentManage set updateTime=? where environmentId ="+environmentId;
		conn = Content.connect(conn);
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1,TimeNow.getTime());
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("设置环境时间成功");
		}
		else {
			System.out.println("修改环境时间失败");
		}
		Content.close(conn,pstmt,null);	
	}
	//增加旧环境
	public static void addOldEnvironment(int oldEnvironmentId) throws ClassNotFoundException, SQLException {
		String sql = "insert into oldEnvironment(oldEnvironmentId) values(?)";
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, oldEnvironmentId);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("增加旧环境成功");
		}
		else {
			System.out.println("增加旧环境失败");
		}
		Content.close(conn,pstmt,null);	
	}
}
