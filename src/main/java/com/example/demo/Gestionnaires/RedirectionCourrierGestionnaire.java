package com.example.demo.Gestionnaires;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Beans.CourrierArrive;
import com.example.demo.Beans.CourrierDepart;
import com.example.demo.Beans.CourrierIntern;
import com.example.demo.Beans.Document;
import com.example.demo.Beans.Etablissement;
import com.example.demo.Beans.Personnel;
import com.example.demo.Beans.TYPE_COURRIER;
import com.example.demo.MailingConfig.MaillingData;
import com.example.demo.Repositories.CourrierArriveDao;
import com.example.demo.Repositories.CourrierDepartDao;
import com.example.demo.Repositories.CourrierInternDao;
import com.example.demo.Repositories.DocumentDao;

@Service
public class RedirectionCourrierGestionnaire {

	
	@Autowired
	private CourrierArriveDao courrierArriveDao;
	@Autowired
	private CourrierDepartDao courrierDepartDao;
	@Autowired
	private CourrierInternDao courrierInternDao;
	@Autowired
	private DocumentDao documentDao;
	@Autowired
	private EntityManager entityManager;
	
	public MaillingData redirectionCourrier(Long numeroCourrier, TYPE_COURRIER typeCourrier) {
		
		Object courrier = null;
		List<Document> documents;
		MaillingData maillingData = new MaillingData();
		String emetteur = null;
		String recepteur = null;
		
		if(typeCourrier == TYPE_COURRIER.ARRIVEE) {
			courrier = courrierArriveDao.findById(numeroCourrier);
			((CourrierArrive)courrier).setRecepteur(entityManager.getReference(Personnel.class, numeroCourrier));
			((CourrierArrive)courrier).setEmetteur(entityManager.getReference(Etablissement.class, numeroCourrier));
			maillingData.setEmail(((CourrierArrive)courrier).getRecepteur().getEmail());
			emetteur = ((CourrierArrive)courrier).getEmetteur().getEmailEtablissement();
			recepteur = ((CourrierArrive)courrier).getRecepteur().getEmail();
			maillingData.setObject(((CourrierArrive)courrier).getObjet());
		}
		else if(typeCourrier == TYPE_COURRIER.DEPART) {
			courrier = courrierDepartDao.findById(numeroCourrier);
			((CourrierDepart)courrier).setRecepteur(entityManager.getReference(Etablissement.class, numeroCourrier));
			((CourrierDepart)courrier).setEmetteur(entityManager.getReference(Personnel.class, numeroCourrier));
			maillingData.setEmail(((CourrierDepart)courrier).getRecepteur().getEmailEtablissement());
			emetteur = ((CourrierDepart)courrier).getEmetteur().getEmail();
			recepteur = ((CourrierDepart)courrier).getRecepteur().getEmailEtablissement();
			maillingData.setObject(((CourrierDepart)courrier).getObjet());
		}
		else {
			courrier = courrierInternDao.findById(numeroCourrier);
			((CourrierIntern)courrier).setRecepteur(entityManager.getReference(Personnel.class, numeroCourrier));
			((CourrierIntern)courrier).setEmetteur(entityManager.getReference(Personnel.class, numeroCourrier));
			maillingData.setEmail(((CourrierIntern)courrier).getRecepteur().getEmail());
			emetteur = ((CourrierIntern)courrier).getEmetteur().getEmail();
			recepteur = ((CourrierIntern)courrier).getRecepteur().getEmail();
			maillingData.setObject(((CourrierIntern)courrier).getObjet());
		}

		documents = documentDao.findByTypeAndForeignKey(typeCourrier, numeroCourrier);
		
		
		
		maillingData.setDocuments(documents);
		maillingData.setName("BUREAU D'ORDRE");
		String feedback = "<h3>message transfere</h3>"
				+ "<p>Emetteur: <b>" + emetteur +"</b></p>"
				+ "<p>Recepteur: <b>"+ recepteur + "</b></p>";
		maillingData.setFeedback(feedback);
		
		return maillingData;
		
	}
	
}
