package com.mail.send;

import java.io.IOException;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mail.filechange.HtmltoString;
/*
 *  * 1组
 */
public class MailUtilHtml {
	static String sender="bai13113893039@126.com";
	static String auth_code="XPZNXMFQYCKBLFYW";
	
	public static void sendMail(String to) throws IOException { 		
		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);	
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}	
		});
		Message message=new MimeMessage(session);
		try {	
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, 
					new InternetAddress(to));
			message.setSubject("测试123");
			message.setContent(HtmltoString.htmltoS(), 
					"text/html; charset=utf-8");
			Transport.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("发送成功");
	
	}
	public static void main(String[] args) throws IOException {
		sendMail("1336124020@qq.com");
	}

}