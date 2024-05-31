package com.apicheck.Apicheker.service;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendMail {

	public boolean isSendMail(String to, String from, String subject,String text) {
		boolean isSend = false;
		
		Properties propertirs = new Properties();
		propertirs.put("mail.smtp.auth",true);
		propertirs.put("mail.smtp.starttls.enable",true);
		propertirs.put("mail.smtp.port", "587");
		propertirs.put("mail.smtp.host","smtp.gmail.com");
		 
		String username = "merawala361";
		String pass = "yiduczwfmcbleqqa";
		
		// to create the seesion
		Session session = Session.getInstance(propertirs,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, pass);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setText(text);
			
			Transport.send(message);
			
			isSend = true;
		}catch(Exception e) {
			System.out.println("There are some errors in sending the email!");;
		 e.printStackTrace();	
		}
		
		return isSend;
	}
	
	public static String checkDuplicationApi() {
		SendMail mail = new SendMail();
		String to = "k4675533@gmail.com";
		String from = "merawala361@gmail.com";
		String subject = "Server API Communication Error !";
		//String text = "Dear client \n we have get your request for make connection between two api's \n but problem is your both source and destination are same \n so please use defferent server to make connection \n \n this is the mail to conform the Email is successfully sended... \n\n Best regard, \n Team VKTeckno Solution";
		String text = "Dear client,\n\nWe have received your request to establish a connection between two APIs. However, the issue arises as both your source and destination are the same.\n\nKindly use different servers to establish the connection.\n\nThis email is to confirm that the email has been successfully sent.\n\nBest regards,\nTeam VKTeckno Solution";

		
    	boolean res = mail.isSendMail(to, from, subject, text);
		
		
		if(res) {
			System.out.println("please check your mail for better Understanding..");
			return "please check your mail for better Understanding..";
		}
		else {
			System.out.println("something went to wrong!");
			return "something went to wrong!";
		}
		
	}
}
