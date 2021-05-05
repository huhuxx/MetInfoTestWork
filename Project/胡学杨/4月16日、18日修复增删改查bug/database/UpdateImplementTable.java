package edu.hxy.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.hxy.string.GetSwagger;
import edu.hxy.string.TimeNow;

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
			System.out.println("接口插入成功");
		}
		Content.close(conn,pstmt,null);	
		UpdateMainPageTable.update();//更新主页
		GetSwagger.setSwagger();
	}
	//改变接口
	public static void changeImplement(int implementId,String implementName,String environment,String requestStyle,String dataStyle,String requestUrl) throws ClassNotFoundException, SQLException {
		String sql = "update implementManage set implementName=?,environment=?,requestStyle=?,dataStyle=?,requestUrl=? where implementId="+implementId;
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, implementName);
		pstmt.setString(2, environment);
		pstmt.setString(3, requestStyle);
		pstmt.setString(4, dataStyle);
		pstmt.setString(5, requestUrl);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("接口修改成功");
		}
		Content.close(conn,pstmt,null);	
		UpdateMainPageTable.update();//更新主页
	}
	//删除接口
	public static void deleteImplement(int implementId) throws ClassNotFoundException, SQLException {
		String sql = "delete from implementManage where implementId="+implementId;
		conn = Content.connect(conn);
		conn.prepareStatement(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		if(result > 0) {
			System.out.println("接口删除成功");
		}
		else {
			System.out.println("接口删除失败");
		}
		Content.close(conn,pstmt,null);	
		UpdateMainPageTable.update();//更新主页
		addOldImplement(implementId);
		GetSwagger.setSwagger();
	}
	//增加旧接口
	public static void addOldImplement(int oldImplementId) throws ClassNotFoundException, SQLException {
		String sql = "insert into oldImplement(oldImplementId) values(?)";
		conn = Content.connect(conn);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, oldImplementId);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("增加旧接口成功");
		}
		else {
			System.out.println("增加旧接口失败");
		}
		Content.close(conn,pstmt,null);	
	}
	//设置swagger
	public static void setSwagger(String environmentName,int num) throws ClassNotFoundException, SQLException {
		String sql = "update environmentManage set swaggerNumber=? where environmentName ='"+environmentName+"'";
		conn = Content.connect(conn);
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		int result = pstmt.executeUpdate();
		if(result>0) {
			System.out.println("更新swagger成功");
		}
		else {
			System.out.println("更新swagger失败");
		}
		Content.close(conn,pstmt,null);	
	}
}
