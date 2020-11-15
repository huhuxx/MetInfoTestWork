package com.webtest.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.ObjectOutputStream.PutField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



import com.webtest.core.JavaMailTestListener;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarker extends JavaMailTestListener {
	public String dir=ReadProperties.getPropertyValue("dir");
	public static Date date;
	public void makeReport() throws IOException, TemplateException {
		Configuration conf = new Configuration();
		//加载模板文件(模板的路径)
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 加载模板
		Template template = conf.getTemplate("/freemarkerReport.ftl");
		// 定义数据
		Map<String, Object> root = new HashMap<String, Object>();
//		Map root = new HashMap();
		root.put("casesize" ,caseSize);
		root.put("failcasesize" ,failSize);
		root.put("successcasesize",successSize);
		root.put("skipsize",skipSize);
		root.put("message", content);
	
		root.put("testMethodsList",testMethodsList);
		
		// 定义输出
		date =new Date();
		root.put("date",date);
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
		String reportFile=dir +"/report"+ft.format(date)+".html";
		Writer out = new FileWriter(reportFile);
		template.process(root, out);

		out.flush();
		out.close();
	}
}
