package com.mail.send;

import java.io.IOException;

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
import javax.mail.internet.MimeUtility;

import com.first.freemarker.testFreemarker;
/*
 *  * 1组
 */
public class MailUtilFile {
	static String sender="bai13113893039@126.com";
	static String auth_code="XPZNXMFQYCKBLFYW";
	
	public static void sendMail(String to) throws IOException { 		
		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.host", "smtp.163.com");
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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("作业");	
			MimeMultipart multipart = new MimeMultipart();		
			MimeBodyPart text = new MimeBodyPart();
			text.setText("2016011405");
			
			MimeBodyPart file = new MimeBodyPart();
			DataHandler dataHandler = new DataHandler(new FileDataSource("D:\\eclipse\\WorkSpace202003\\appium-api\\freemarkerHtml\\freemarker.html"));
		    file.setDataHandler(dataHandler);
		    file.setFileName(MimeUtility.encodeText(dataHandler.getName()));
		    multipart.addBodyPart(file);
		    multipart.addBodyPart(text);
		    multipart.setSubType("mixed");
		     
			message.setContent(multipart);
			message.saveChanges();
			Transport.send(message);		
			System.out.println(dataHandler.getName());
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