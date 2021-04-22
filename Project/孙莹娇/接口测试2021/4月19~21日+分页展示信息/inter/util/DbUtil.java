package com.inter.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @clsName DbUtil
 * @description ���ݿ⹤���࣬���ڴ򿪻�ر�����
 * @author adi
 *
 */
public class DbUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return
	 */
	public static Connection getCon() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/implementTest?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8","root","123456");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstm, Connection con) {
		try {
			if(rs!=null)
				rs.close();
			if(pstm!=null)
				pstm.close();
			if(con!=null)
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
