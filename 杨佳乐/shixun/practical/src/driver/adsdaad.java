package driver;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class adsdaad {
	public static void main(String[] args) {
		String sender="yjl1837519045@126.com";
		//授权码
		String auth_code="YATGOUGSDVGTJSIR";
		String to="1837519045@qq.com";
		
		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);
		
		
		
		//1、构造Session对象（邮件会话对象），设置服务器，授权码，需要Properties对象
		Session session=Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}
			
		});
		
		//2、创建邮件，创建Message对象，子类 MimeMessage
		//设置发件人、收件人、主题、正文
		Message message=new MimeMessage(session);
		try {
			
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("我的错误");
			message.setText("杨佳乐2018011681+error+错误了");
		//3、发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}