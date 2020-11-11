package utils;

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

import java.io.FileInputStream;
import java.io.IOException;

public class MailUtil {
	public static void Mail() throws IOException {
		String sender="yjl1837519045@126.com";
		//授权码
		String auth_code="YATGOUGSDVGTJSIR";
		Properties props=new Properties();
		FileInputStream fis = new FileInputStream("config.properties");
		props.load(fis);
		fis.close();
		String to=props.getProperty("tomail");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);
		//1、构造Session对象（邮件会话对象），设置服务器，授权码，需要Properties对象
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, auth_code);
			}
		});
		//2、创建邮件，创建Message对象，子类 MimeMessage
		//设置发件人、收件人、主题、正文
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("杨佳乐-2018011720");
			//发送HTML格式的邮件
			MimeMultipart mimeMultipart=new MimeMultipart();
			MimeBodyPart mimeBodyPart=new MimeBodyPart();
			mimeBodyPart.setContent(mimeMultipart,"text/html;charset=utf-8");
			DataHandler dataHandler = new DataHandler(new FileDataSource("D:\\eclipse\\practical\\src\\fm\\freemarker.html"));
			mimeBodyPart.setDataHandler(dataHandler);
		    mimeBodyPart.setFileName(MimeUtility.encodeText(dataHandler.getName()));
			mimeMultipart.addBodyPart(mimeBodyPart);
			mimeMultipart.setSubType("mixed");
			message.setContent(mimeMultipart);

		//3、发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
