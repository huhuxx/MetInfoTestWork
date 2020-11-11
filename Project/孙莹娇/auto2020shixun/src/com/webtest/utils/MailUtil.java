package com.webtest.utils;



import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	// 发送者
	public String sender = ReadProperties.getPropertyValue("sender");

	// 授权码
	public String auth_code = ReadProperties.getPropertyValue("auth_code");
	// 接收方
	public String to = ReadProperties.getPropertyValue("tomail");
	
	// 协议
	public String pro1 = ReadProperties.getPropertyValue("pro1");
	public String pro2 = ReadProperties.getPropertyValue("pro2");
	public String pro3 = ReadProperties.getPropertyValue("pro3");
	public String value1 = ReadProperties.getPropertyValue("value1");
	public String value2 = ReadProperties.getPropertyValue("value2");
	
	
	public Properties props;
	
	public MailUtil() {
		props = new Properties();
		props.put(pro1, value1);
		props.put(pro2, value2);
		props.put(pro3,true);
		
	}

	public void sendMail(String content) {
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}

		});
		// 设置发件人、收件人、主题、正文
		Message message = new MimeMessage(session);
		try {
			
			message.setFrom(new InternetAddress(sender));
			String toArray[]=to.split(",");
			for (int i = 0; i < toArray.length; i++) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(toArray[i]));
			}
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("发送邮件-孙莹娇");
			message.setText(content);
					

			// 发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
