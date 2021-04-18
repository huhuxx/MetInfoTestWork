package com.bai.dao;

import java.util.List;
import java.util.Map;

import com.bai.bean.Item;

public interface ItemDao {
	public int save(Item api);
	public int delete(int id);
	public int updata(Item api);
	public List<Map<String, Object>> findAll();
}
