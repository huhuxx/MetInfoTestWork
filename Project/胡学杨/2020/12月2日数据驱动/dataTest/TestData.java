package com.hxy.dataTest;

import org.testng.annotations.Test;

import com.hxy.dataProvider.NSDataProvider;

public class TestData {
	@Test(dataProvider = "excel",dataProviderClass = NSDataProvider.class)
	public void u(String text) throws InterruptedException {
		System.out.println(text);
	}
}
