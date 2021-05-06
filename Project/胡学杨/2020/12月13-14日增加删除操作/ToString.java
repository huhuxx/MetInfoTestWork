package edu.hxy.string;

import java.io.UnsupportedEncodingException;

public class ToString {
	public static String toString(String string) throws UnsupportedEncodingException {
		byte b[]=string.getBytes("ISO-8859-1");
		String a=new String(b,"UTF-8");
		return a;
	}
}
