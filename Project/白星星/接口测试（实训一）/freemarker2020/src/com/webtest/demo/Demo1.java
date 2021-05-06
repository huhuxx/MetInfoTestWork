package com.webtest.demo;

import org.testng.annotations.Test;

import com.freemarker.WebTestListener;


public class Demo1 extends BaseTest{
	WebTestListener l1= new WebTestListener();
	@Test()
	public void demo() {
		l1.onFinish(null);
		System.out.println("hello");
	}
}

