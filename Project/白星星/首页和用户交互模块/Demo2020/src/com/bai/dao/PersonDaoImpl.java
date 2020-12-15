package com.bai.dao;

import java.util.List;
import java.util.Map;

import com.bai.bean.Api;
import com.bai.bean.Person;
import com.bai.util.DBUtil;

public class PersonDaoImpl implements PersonDao {

	@Override
	public List<Map<String, Object>> findAll() {
		// 查询
		List<Map<String, Object>> list = DBUtil.findAll("select * from person");
		return list;
	}

	@Override
	public int save(Object[] person) {
		// 增加
		int count = 0;
		DBUtil dbUtil = new DBUtil();
		count = dbUtil.executeUpdate("insert into person values(?,?,?,?,?,?,?,?)", 
				person);
		
		return count;
	}


	@Override
	public int updata(Object[] person) {
		// 修改
		int count = 0;
		DBUtil dbUtil = new DBUtil();
		count = dbUtil.executeUpdate("update person set id=?,name=?,password=?,email=?,tright=? where name=? ", 
				person);
		return count;
	}

	@Override
	public Object findAllById(Class person,int id) {
		int count = 0;
		DBUtil dbUtil = new DBUtil();
		return dbUtil.findById(person,id);
		
	}

	@Override
	public int delete(Object[] name) {
		int count = 0;
		DBUtil dbUtil = new DBUtil();
		count = dbUtil.executeUpdate("delete from person where name=?", 
				name);
		return count;
	}


}
