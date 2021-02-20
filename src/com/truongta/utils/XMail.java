package com.truongta.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class XMail {
	static public void sendMail(String to,String title,String content) {
		Properties	prop = new Properties();
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.smtp.port", "587");
		
		Session s = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				String user = "taltpc00653@fpt.edu.vn";
				String pass = "27022001a";
				return new PasswordAuthentication(user, pass);
			}
		});
		MimeMessage mess = new MimeMessage(s);
		try {
			mess.setFrom(new InternetAddress("taltpc00653@fpt.edu.vn"));
			mess.setRecipients(Message.RecipientType.TO, to);
			mess.setSubject(title,"utf-8");
			mess.setText(content,"utf-8","html");
			mess.setReplyTo(mess.getFrom());
			Transport.send(mess);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
