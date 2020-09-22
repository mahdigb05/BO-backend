package com.example.demo.Utils;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.demo.Beans.Document;
import com.example.demo.MailingConfig.MaillingData;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(MaillingData maillingData) throws MessagingException {
		
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg,true);
		
		helper.setTo(maillingData.getEmail());
		helper.setSubject(maillingData.getObject());
		helper.setText(maillingData.getFeedback(),true);
		
		for(Document doc:maillingData.getDocuments()) {
			FileSystemResource file = new FileSystemResource(new File(doc.getNomDocument()));
			helper.addAttachment(doc.getNomDocument(), file);
		}
    	
    	javaMailSender.send(msg);
	}
	
}
