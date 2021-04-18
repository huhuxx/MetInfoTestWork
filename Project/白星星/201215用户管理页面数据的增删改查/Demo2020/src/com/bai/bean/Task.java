package com.bai.bean;

import java.util.Date;

public class Task {
	private int id;
	private String name;
	private Date time;
	public Task() {}
	public Task(int id,String name,Date time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
