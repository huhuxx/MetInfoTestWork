package com.webtest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static final String filePath="conf/config.properties";
	
	public static String getPropertyValue(String key){
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return  prop.getProperty(key);
		
	}

}
