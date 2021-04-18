package com.bai.dao;

import java.util.List;
import java.util.Map;

import com.bai.bean.Api;

public interface ApiDao {
	public int save(Api api);
	public int delete(int id);
	public int updata(Api api);
	public List<Map<String, Object>> findAll();
}
