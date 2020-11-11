package com.bxx.utils;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtil {

	public void sendMessage(String outcome) throws IOException {
		String sender = "1336124020@qq.com";
		//授权码
		String auth_code ="VZWDRLIBCRCPABRM";
		String[] to = ReadProperties.getPropertyValue("tomail").split(",");
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);
		
		//1、构造Session对象（邮件会话对象），设置服务器、授权码，需要Properties对象
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}
			
		});
		
		//2、创建邮件，创建Message对象，一般用子类MimeMessage
		Message message = new MimeMessage(session);
		try {
			//设置发件人、收件人、主题、正文
			message.setFrom(new InternetAddress(sender));
			for (int i = 0; i < to.length; i++) {
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(to[i]));
			}
			message.setSubject("hello,白星星");
			message.setText(outcome);
			
			
			//3、发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
