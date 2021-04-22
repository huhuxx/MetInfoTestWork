package com.inter.service;

import java.util.List;

import com.inter.dao.InterDaoImpl;
import com.inter.entity.InterfaceRecord;
import com.inter.entity.Page;

public class InterServiceImpl {
	public Page<InterfaceRecord> listByPage(int pageNum, int pageSize,String tableName){
		Page<InterfaceRecord> page=new Page<InterfaceRecord>(pageNum,pageSize);
		//调用Dao层方法
		InterDaoImpl interDaoImpl=new InterDaoImpl();
		//计算总的数据量
		int count=interDaoImpl.countByPage(tableName);
		//获取保存着要查询数据的list
		List<InterfaceRecord> list=interDaoImpl.findByPage(pageNum, pageSize,tableName);
		//page对象中的list保存数据集合，以便jsp中直接取出
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
}
