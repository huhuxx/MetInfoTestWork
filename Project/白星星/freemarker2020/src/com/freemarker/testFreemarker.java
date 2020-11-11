package com.freemarker;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class testFreemarker {
	public static void main(String[] args) throws Exception {
		String dir="D:\\eclipse\\WorkSpace201109\\freemarker2020\\src\\com\\freemarker";

        Map<String,Object> titleMap = new HashMap<String, Object>();
        titleMap.put("date",new Date() );
        titleMap.put("casesize", "测试的数目");
        titleMap.put("failcasesize", "失败的测试用例数目");
        
        
        
        createDayReportFiles(titleMap,dir+"/result.html",dir,"reportTemplate.ftl");
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
