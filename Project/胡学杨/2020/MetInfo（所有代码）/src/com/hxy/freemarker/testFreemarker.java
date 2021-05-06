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
	private String dir="B:\\Study\\mianxiang\\mian2\\MetInfo";
	private Map<String, List<Map<String, Object>>> root = new HashMap<String, List<Map<String, Object>>>();
	private List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
	private List<Map<String,Object>> maps1 = new ArrayList<Map<String,Object>>();
	private List<Map<String,Object>> maps2 = new ArrayList<Map<String,Object>>();
	
	private List<Map<String,Object>> maps3 = new ArrayList<Map<String,Object>>();

	
	public void testSum(int testsum,int ssum,int fsum) {
		Map<String,Object> sum = new HashMap<String,Object>();
		sum.put("testsum", testsum);
		sum.put("ssum", ssum);
		sum.put("fsum", fsum);
		maps3.add(sum);
		System.out.println(testsum+"++++++++++++++++");
		root.put("maps3",maps3);
	}
	
	public void createData(String testName,Object testResult) {
		Map<String,Object> test = new HashMap<String,Object>();
		test.put("testName",testName);
		test.put("testResult",testResult);
		maps.add(test);
		root.put("maps", maps);		
	}
	public void createSuccessData(String testName,Object testResult) {
		Map<String,Object> test = new HashMap<String,Object>();
		test.put("testName",testName);
		test.put("testResult",testResult);
		maps1.add(test);
		root.put("maps1", maps1);	
	}
	public void createFailData(String testName,Object testResult) {
		Map<String,Object> test = new HashMap<String,Object>();
		test.put("testName",testName);
		test.put("testResult",testResult);
		maps2.add(test);
//		fsum = fsum + 1;
//		sum.put("fsum", fsum);
//		maps2.add(sum);
		root.put("maps2", maps2);		
	}
	
	
	public void createHtml() throws IOException, TemplateException {
		Configuration conf = new Configuration();
		
		conf.setDirectoryForTemplateLoading(new File(dir));
		
		Template template = conf.getTemplate("\\freemarkerMB\\freemarker-table.ftl");
		
		
		
		Writer out = new FileWriter(dir+"\\freemarkerHtml\\freemarker.html");
		template.process(root, out);
		System.out.println("html创建成功--------------------------------------------");
		out.flush();
		out.close();
	}
}



