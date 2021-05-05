package com.inter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.inter.entity.InterfaceRecord;
import com.inter.util.DbUtil;

public class InterDaoImpl {
	public static void main(String[] args) {
		InterDaoImpl daoImpl=new InterDaoImpl();
		daoImpl.countByPage("");
	}
	/*
	 * 计算数据共有多少条
	 */
	public int countByPage(String tableName){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql="SELECT * from "+tableName+";";
			//加载驱动，建立数据库连接
			con = DbUtil.getCon();			
			//获取用于向数据库发送sql语句的PreparedStatement对象
			pstm = con.prepareStatement(sql);
			//向数据库发送sql
			rs = pstm.executeQuery();
			while (rs.next()) {
				count++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//关闭数据库
			DbUtil.close(rs, pstm, con);
		}
		return count;
	}
	/*
	 * 从pageNum行开始【默认第一行为0】，查询pageSize行数据
	 */
	public List<InterfaceRecord> findByPage(int pageNum, int pageSize,String tableName){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<InterfaceRecord> list = new ArrayList<>();
		try {
			String sql="SELECT * from "+tableName+" limit ?, ?;";
			con = DbUtil.getCon();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (pageNum-1)*pageSize);
			pstm.setInt(2, pageSize);
		
			rs = pstm.executeQuery();
			while(rs.next()) {
				//将查到的结果保存在interfaceRecord对象中，并保存到list中
				InterfaceRecord interfaceRecord=new InterfaceRecord();
				interfaceRecord.setImpId(rs.getInt(1));
				interfaceRecord.setImpName(rs.getString(2));
				interfaceRecord.setEnvironment(rs.getString(3));
				interfaceRecord.setRequestStyle(rs.getString(4));
				interfaceRecord.setRequestStyle(rs.getString(5));
				interfaceRecord.setRequestURL(rs.getString(6));
				list.add(interfaceRecord);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(rs, pstm, con);
		}
		return list;
	}
}
