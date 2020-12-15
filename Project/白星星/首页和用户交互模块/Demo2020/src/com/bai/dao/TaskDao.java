package com.bai.dao;

import java.util.List;
import java.util.Map;

import com.bai.bean.Task;

public interface TaskDao {
	public int save(Task task);
	public int delete(int id);
	public int updata(Task task);
	public List<Map<String, Object>> findAll();
}
