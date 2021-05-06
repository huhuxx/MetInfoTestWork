package com.bxx.freemarker;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;

import com.bxx.core.WebTestListener1;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Freemarker {
	public static void main(String[] args) throws Exception {
		
	}
	public static void finish() {
		String dir="D:\\eclipse\\WorkSpace201109\\selenium201109\\src\\com\\bxx\\freemarker";
		int allTest =  WebTestListener1.all;
		List<ITestResult> passList = WebTestListener1.passList;
		int passTest =  passList.size();
		List<ITestResult> failList = WebTestListener1.failList;
		int failTest = failList.size();
		List<ITestResult> skipList = WebTestListener1.skipList;
		int skipTest = skipList.size();
        Map<String,Object> testMap = new HashMap<String, Object>();
        testMap.put("dateTime",new Date());
        testMap.put("alltest", allTest);
        testMap.put("passedtest", passTest);
        testMap.put("failedtest", failTest);
        
        List<Map<String,String>> testList = new ArrayList<Map<String,String>>();
        Map<String, String> test1 = new HashMap<String, String>();
        test1.put("group",String.valueOf(allTest));
        test1.put("pass", String.valueOf(passTest));
        test1.put("fail", String.valueOf(failTest));
        test1.put("skip", String.valueOf(skipTest));
        test1.put("user", "bai");
        testList.add(test1);
        testMap.put("maps", testList);
    
        
        List<Map<String,String>> passes = new ArrayList<Map<String,String>>();
        Map<String, String> testpass = new HashMap<String, String>();
        if (passTest == 0) {
			testpass.put("InstanceName1", "null");
			testpass.put("Name1", "null");
		}else {
			for (int i = 0; i < passTest; i++) {
	        	ITestResult trPass = passList.get(i);
	        	testpass = new HashMap<String, String>();
	        	testpass.put("InstanceName1", trPass.getInstanceName());
				testpass.put("Name1", trPass.getName());
				passes.add(testpass);
			}
		}
        
		testMap.put("passes",passes);     
        
        
        List<Map<String,String>> failed = new ArrayList<Map<String,String>>();
        Map<String, String> testfail =new HashMap<String, String>();
        if (failTest == 0) {
        	testfail.put("InstanceName2", "null");
			testfail.put("Name2", "null");
		}else {
			for (int i = 0; i < failTest; i++) {
	        	ITestResult trfail = failList.get(i);
	        	testfail = new HashMap<String, String>();
	        	testfail.put("InstanceName2", trfail.getInstanceName());
				testfail.put("Name2", trfail.getName());
				failed.add(testfail);
			}
		}
        
        
		testMap.put("failed",failed);
        
        
        List<Map<String,String>> skipped = new ArrayList<Map<String,String>>();
        Map<String, String> testskip = new HashMap<String, String>();
        if (skipTest == 0) {
        	testskip.put("InstanceName3", "null");
			testskip.put("Name3", "null");
			skipped.add(testskip);
		} else {
			for (int i = 0; i < skipTest; i++) {
	        	ITestResult trSkip =skipList.get(i);
	        	testskip = new HashMap<String, String>();
	        	testskip.put("InstanceName3", trSkip.getInstanceName());
				testskip.put("Name3", trSkip.getName());
				skipped.add(testskip);
			}
		}
        
		testMap.put("skipped",skipped);
        
     
        
        createDayReportFiles(testMap,dir+"/result.html",dir,"freemarker-demo.ftl");
	}


	/**
	    * 通过JSON生成Html，Excel，Word
	    * @param data 数据源
	    * @param fileName 文件名
	    * @param templateFilePath 文件路径
	    * @param templateFile 模板
	    */
	    public static void createDayReportFiles(Map<String,Object> data,String fileName,String templateFilePath,String templateFile) {
	        BufferedInputStream in = null;
	        Writer out = null;  
	        Template template = null;
	        try {
	  
	            //构造Configuration
	            Configuration configuration = new Configuration();
	            configuration.setDefaultEncoding("utf-8");  
	            configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
	            configuration.setDirectoryForTemplateLoading(new File(templateFilePath));
	            
	            
	            try {  
	                //test.ftl为要装载的模板  
	            	template = configuration.getTemplate(templateFile);  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	          
	           
	            //输出文档路径及名称  
	            File outFile = new File(fileName);  
	           
	            FileOutputStream fos = null;  
	            try {  
	                fos = new FileOutputStream(outFile);  
	                OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");  
	                //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。  
	                 out = new BufferedWriter(oWriter);   
	                 
	            } catch (FileNotFoundException e1) {  
	                e1.printStackTrace();  
	            }  
	            
	            //生成HTML
	            template.process(data, out);
	            System.out.println("已经产生测试报告HTML");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (TemplateException e) {
	            e.printStackTrace();
	        } finally {
	            if(null != in) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if(null != out) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	    }

}

