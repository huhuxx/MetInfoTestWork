package com.hxy.freemarker;

import java.io.IOException;

import freemarker.template.TemplateException;

public class Demo {
	public static void main(String[] args) throws IOException, TemplateException {
		testFreemarker a = new testFreemarker();
		String testName = "1";
		Object testResult = "1";
		a.createData(testName, testResult);
		a.createData(testName, testResult);
		a.createData(testName, testResult);
		a.createHtml();
	}
}
