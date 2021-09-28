package com.Mail.SpringBoot_Email;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService 
{
   @Autowired
   private JavaMailSender javaMailSender;
   
   /* we have to configure our email in application.properties file and
     https://security.google.com/settings/security/apppasswords here we have login from our 
     email from where we send the mail and generate the password that password we have to give
     in application.properties file password */
   
   public void sendEmail(String to, String body,String topic)
   {
	   System.out.println("Mail Start Sending .....");
	   SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
	   simpleMailMessage.setFrom("anupamguin7585@gmail.com");
	   simpleMailMessage.setTo(to);
	   simpleMailMessage.setSubject(topic);
	   simpleMailMessage.setText(body);
	   simpleMailMessage.setSentDate(new Date());
	   javaMailSender.send(simpleMailMessage);
	   System.out.println("Mail Sending SUccessfully.....");
   }
}
