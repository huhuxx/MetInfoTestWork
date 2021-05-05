package edu.hxy.string;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeNow {
	public static String getTime() {
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return df.format(day);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getTime());   
	}
}
