package com.bai.dao;

import java.util.List;
import java.util.Map;

import com.bai.bean.Api;
import com.bai.util.DBUtil;

public class ApiDaoImpl implements ApiDao {

	@Override
	public int save(Api api) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updata(Api api) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>> list = DBUtil.findAll("select * from api");
		return list;
	}
	
}
