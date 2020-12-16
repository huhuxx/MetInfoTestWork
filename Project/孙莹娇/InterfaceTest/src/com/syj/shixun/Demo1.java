package com.syj.shixun;

import com.jfinal.core.Controller;

public class Demo1 extends Controller{
	public void index() {
		this.render("/login.jsp");
	}
}
