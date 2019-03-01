package com.app.util;



import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;



@Component
public class CommonUtil {
	@Autowired
private JavaMailSender mailSender;
	public void sendEmail(String to,String sub,String txt,final CommonsMultipartFile file)
	{
		MimeMessage message=mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setFrom("rathodkiranece@gmail.com");
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(txt);
			helper.addAttachment(file.getOriginalFilename(), new InputStreamSource()
			{
				public InputStream getInputStream() throws IOException
				{
					return file.getInputStream();
				}
			});
		mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void sendEmail(String to,String sub,String txt)
		{
			MimeMessage message=mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper=new MimeMessageHelper(message,true);
				helper.setFrom("rathodkiranece@gmail.com");
				helper.setTo(to);
				helper.setSubject(sub);
				helper.setText(txt);
				mailSender.send(message);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
