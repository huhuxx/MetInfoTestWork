package com.hxy.dataTest;

import org.testng.annotations.Test;

import com.hxy.dataProvider.NSDataProvider;

public class TestData {
//	@Test(dataProvider = "excel",dataProviderClass = NSDataProvider.class)
//	public void u(String text) throws InterruptedException {
//		System.out.println(text);
//	}
	@Test(dataProvider = "excel2",dataProviderClass = NSDataProvider.class)
	public void u1(String text,String text1) throws InterruptedException {
		System.out.println(text+","+text1);
	}
}
