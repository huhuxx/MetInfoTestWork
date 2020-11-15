package com.hxy.mail;

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
import com.hxy.filechange.HtmltoString;

public class MailUtilHtml {
	static String sender="Hu_xueyang123@163.com";
	static String auth_code="ULHRIFNRUDUKHWOS";
	
	public static void sendMail(String to) throws IOException { 		
		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.163.com");
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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("作业123");
			message.setContent(HtmltoString.htmltoS(), "text/html; charset=utf-8");
			Transport.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("发送成功");
	
	}
	public static void main(String[] args) throws IOException {
		sendMail("1647524030@qq.com");
	}

}