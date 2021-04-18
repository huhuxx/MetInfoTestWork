package com.Interface.service;

import java.util.List;
import java.util.Map;

import com.Interface.dao.RequestDaoImpl;
import com.Interface.entity.Request;
public class ReqServiceImpl {
	public List<Map<String, Object>> listRequests() {
		return new RequestDaoImpl().findAll();
	}
	
	public List<Request> listAllRequests(){
		return new RequestDaoImpl().findAllRequest();
	}

	public boolean addRequest(Request request) {
		int count = new RequestDaoImpl().saveRequest(request);
		return count > 0;
	}
	
	public Request getRequeste(int id) {
		return new RequestDaoImpl().findById(id);
	}

	public boolean editRequest(Request request) {
		int count = new RequestDaoImpl().updateRequest(request);
		return count > 0;
	}

	public boolean dropEmployee(int id) {
		int count = new RequestDaoImpl().deleteRequest(id);
		return count > 0;
	}
}
