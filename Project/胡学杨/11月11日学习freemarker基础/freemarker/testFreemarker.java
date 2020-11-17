package com.hxy.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class testFreemarker {
	private String dir="D:\\mianxiang\\mian2\\MetInfo";
	private Map<String, List<Map<String, Object>>> root = new HashMap<String, List<Map<String, Object>>>();
	private List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();

	public void createData(String testName,Object testResult) {
		Map<String,Object> test = new HashMap<String,Object>();
		test.put("testName",testName);
		test.put("testResult",testResult);
		maps.add(test);
		root.put("maps", maps);		
	}
	
	public void createHtml() throws IOException, TemplateException {
		Configuration conf = new Configuration();
		//加载模板文件(模板的路径)
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 加载模板
		Template template = conf.getTemplate("\\freemarkerMB\\freemarker-table.ftl");
		// 定义数据	
		// 定义输出
		Writer out = new FileWriter(dir+"\\freemarkerHtml\\freemarker.html");
		template.process(root, out);
		System.out.println("转换成功--------------------------------------------");
		out.flush();
		out.close();
	}
}




//	public static void main(String[] args) throws Exception {
//		String dir="D:\\mianxiang\\mian2\\MetInfo";
//		Configuration conf = new Configuration();
//		//加载模板文件(模板的路径)
//		conf.setDirectoryForTemplateLoading(new File(dir));
//		// 加载模板
//		Template template = conf.getTemplate("\\freemarkerMB\\freemarker-list.ftl");
//		// 定义数据	
//		Map<String, List<Map<String, Object>>> root = new HashMap<String, List<Map<String, Object>>>();
//		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
//		Map<String,Object> test = new HashMap<String,Object>();
//		test.put("testName","Demo");
//		test.put("testResult","True");
//		maps.add(test);
//		root.put("maps", maps);		
//		// 定义输出
//		Writer out = new FileWriter(dir+"\\freemarkerHtml\\freemarker.html");
//		template.process(root, out);
//		System.out.println("转换成功");
//		out.flush();
//		out.close();
//	}