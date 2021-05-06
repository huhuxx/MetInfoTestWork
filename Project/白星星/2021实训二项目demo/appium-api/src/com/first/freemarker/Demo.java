package com.first.freemarker;

import java.io.IOException;

import freemarker.template.TemplateException;
/*
 *  * 胡学杨
 */
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
