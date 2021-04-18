package com.bai.bean;

import java.util.Date;

public class Person {
	private int id;
	private String name;
	private String password;
	private Date gen_time;
	private Date last_login_time;
	private String email;
	private int count;
	private int tright;
	public Person() {}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getGen_time() {
		return gen_time;
	}
	public void setGen_time(Date gen_time) {
		this.gen_time = gen_time;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTright() {
		return tright;
	}
	public void setTright(int tright) {
		this.tright = tright;
	}
	
	
}
