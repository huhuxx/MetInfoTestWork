package com.bai.dao;

import java.util.List;
import java.util.Map;

import com.bai.bean.Api;
import com.bai.bean.Item;
import com.bai.bean.Task;
import com.bai.util.DBUtil;

public class TaskDaoImpl implements TaskDao {



	@Override
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>> list = DBUtil.findAll("select * from task");
		return list;
	}

	@Override
	public int save(Task task) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updata(Task task) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
