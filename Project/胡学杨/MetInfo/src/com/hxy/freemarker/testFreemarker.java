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
		//鍔犺浇妯℃澘鏂囦欢(妯℃澘鐨勮矾寰�)
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 鍔犺浇妯℃澘
		Template template = conf.getTemplate("\\freemarkerMB\\freemarker-table.ftl");
		// 瀹氫箟鏁版嵁	
		
		// 瀹氫箟杈撳嚭
		Writer out = new FileWriter(dir+"\\freemarkerHtml\\freemarker.html");
		template.process(root, out);
		System.out.println("html创建成功--------------------------------------------");
		out.flush();
		out.close();
	}
}




//	public static void main(String[] args) throws Exception {
//		String dir="D:\\mianxiang\\mian2\\MetInfo";
//		Configuration conf = new Configuration();
//		//鍔犺浇妯℃澘鏂囦欢(妯℃澘鐨勮矾寰�)
//		conf.setDirectoryForTemplateLoading(new File(dir));
//		// 鍔犺浇妯℃澘
//		Template template = conf.getTemplate("\\freemarkerMB\\freemarker-list.ftl");
//		// 瀹氫箟鏁版嵁	
//		Map<String, List<Map<String, Object>>> root = new HashMap<String, List<Map<String, Object>>>();
//		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
//		Map<String,Object> test = new HashMap<String,Object>();
//		test.put("testName","Demo");
//		test.put("testResult","True");
//		maps.add(test);
//		root.put("maps", maps);		
//		// 瀹氫箟杈撳嚭
//		Writer out = new FileWriter(dir+"\\freemarkerHtml\\freemarker.html");
//		template.process(root, out);
//		System.out.println("杞崲鎴愬姛");
//		out.flush();
//		out.close();
//	}