package com.webtest.utils;


import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil extends FreeMarker{
	
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
	
	public String dir=ReadProperties.getPropertyValue("dir");
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
//			设置标题
			message.setSubject("发送邮件-孙莹娇");
			message.setText(content);
			
//			一个Multipart对象包含一个或多个bodypart对象，组成邮件正文
			MimeMultipart mimeMultipart =new MimeMultipart();
			//读取本地测试报告文件,将文件添加到"节点"
			MimeBodyPart file=new MimeBodyPart();
			SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
			DataHandler dataHandler1 = new DataHandler(new FileDataSource(dir +"/report"+ft.format(date)+".html"));
	        file.setDataHandler(dataHandler1);
	        
	        mimeMultipart.addBodyPart(file);
	        message.setContent(mimeMultipart);
					

			// 发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
