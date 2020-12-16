package com.Interface.dao;


import java.util.List;
import java.util.Map;

import com.Interface.entity.Request;

import util.DBUtil;

public class RequestDaoImpl {
	public List<Map<String, Object>> findAll() {
		return DBUtil.findAll("select * from requests");
	}
	
	public List<Request> findAllRequest(){
		return DBUtil.find(Request.class, "select * from requests", null);
	}
	
	public int saveRequest(Request request) {
		return DBUtil.executeUpdate("insert into requests (url,requestMethod) values (?,?)", new Object[] {request.geturl(), request.getRequestMethod() });
	}
	
	public Request findById(int id) {
		Object obj = DBUtil.findById(Request.class, id);
		return obj != null ? (Request)obj : null;
	}
	
	public int updateRequest(Request request) {
		return DBUtil.executeUpdate("update requests set requestMethod=? set srcString=? where requestId=?", 
				new Object[] {request.getRequestMethod(),request.geturl(),request.getRequestId()});
	}
	
	public int deleteRequest(int id) {
		return DBUtil.executeUpdate("delete from requests where requestId=?", new Object[] {id});
	}

}
