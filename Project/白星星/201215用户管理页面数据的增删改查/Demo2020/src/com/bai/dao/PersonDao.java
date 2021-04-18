package com.bai.dao;

import java.util.List;
import java.util.Map;

import com.bai.bean.Person;

public interface PersonDao {
	public int save(Object[] person);
	public int delete(Object[] name);
	public int updata(Object[] person);
	public List<Map<String, Object>> findAll();
	public Object findAllById(Class cla,int id);
}
