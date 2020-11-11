package com.webtest.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.webtest.utils.ReadProperties;

public class MailUtil {
	
	public void SendMail(String send) throws IOException {
		String sender = "xiongjingyigirl@126.com";
		String auth_code = "PDOIJZPIAZHBUFOB";
		String tomail_receiver = ReadProperties.getPropertyValue("tomail");
		String[] address = tomail_receiver.split(",");
		for(String emailaddress: address) {
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.126.com");
			props.put("mail.smtp.auth", true);
			//1、构造Session对象(邮件会话对象)，设置服务器，授权码，需要Properties对象
			Session session = Session.getInstance(props,new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(sender,auth_code);
				}
				
			});
			
			//2、创建邮件，创建Message对象，子类MimeMessage
			//设置发件人、收件人、主题、正文
			javax.mail.Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(sender));
				message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(emailaddress));
				message.setSubject("hello,我是熊静祎");
				//发送文本
				message.setText(send);
				//3、发送邮件
				Transport.send(message);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
