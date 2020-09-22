package com.example.demo.Controlleurs;

import java.util.HashMap;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.TYPE_COURRIER;
import com.example.demo.Gestionnaires.RedirectionCourrierGestionnaire;
import com.example.demo.MailingConfig.MaillingData;
import com.example.demo.Utils.EmailUtil;

@RestController
public class RedirectionCourrierControlleur {

	@Autowired
	private RedirectionCourrierGestionnaire redirectionCourrierGestionnaire;
	@Autowired
	private EmailUtil emailUtil;
	
	@PostMapping("/RBO/redirectionCourrier")
	public ResponseEntity<?> redirectCourrier(@RequestBody HashMap<String, Object> map)
	{
		MaillingData maillingData = null;
		maillingData = redirectionCourrierGestionnaire.redirectionCourrier((Long)map.get("numeroCourrier"), (TYPE_COURRIER)map.get("typeCourrier"));
		try {
			emailUtil.sendEmail(maillingData);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("courrier transferer avec succes",HttpStatus.OK);
	}
	
	
	
}
