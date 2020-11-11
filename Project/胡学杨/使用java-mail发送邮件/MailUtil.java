package com.hxy.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {
	static String sender="Hu_xueyang123@163.com";
	static String auth_code="ULHRIFNRUDUKHWOS";
	
	public static void sendMail(String error,String to) throws IOException { 
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
			 Multipart mainPart = new MimeMultipart();
		        // 创建一个包含HTML内容的MimeBodyPart
		        BodyPart html = new MimeBodyPart();
				// 设置HTML内容
		        html.setContent(((Part) props).getContent(), "text/html; charset=utf-8");
		        mainPart.addBodyPart(html);
		        // 将MiniMultipart对象设置为邮件内容
		        message.setContent(mainPart);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			message.setSubject("我的错误");
//			message.setText(error+"错误了");
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println(error);
		System.out.println(to);
	}

}