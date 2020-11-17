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
	
	// ������
	public String sender = ReadProperties.getPropertyValue("sender");

	// ��Ȩ��
	public String auth_code = ReadProperties.getPropertyValue("auth_code");
	// ���շ�
	public String to = ReadProperties.getPropertyValue("tomail");
	
	// Э��
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

	public void sendMail() {
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}

		});
		// ���÷����ˡ��ռ��ˡ����⡢����
		Message message = new MimeMessage(session);
		try {
			
			message.setFrom(new InternetAddress(sender));
			String toArray[]=to.split(",");
			for (int i = 0; i < toArray.length; i++) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(toArray[i]));
			}
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			���ñ���
			message.setSubject("�����ʼ�-��Ө��");
//			message.setText(content);
			
//			һ��Multipart�������һ������bodypart��������ʼ�����
			MimeMultipart mimeMultipart =new MimeMultipart();
			//��ȡ���ز��Ա����ļ�,���ļ���ӵ�"�ڵ�"
			MimeBodyPart file=new MimeBodyPart();
			SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
			DataHandler dataHandler1 = new DataHandler(new FileDataSource(dir +"/report"+ft.format(date)+".html"));
	        file.setDataHandler(dataHandler1);
	        
	        mimeMultipart.addBodyPart(file);
	        message.setContent(mimeMultipart);
					

			// �����ʼ�
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
