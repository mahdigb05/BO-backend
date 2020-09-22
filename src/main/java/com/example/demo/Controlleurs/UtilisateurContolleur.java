package com.example.demo.Controlleurs;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.Utilisateur;
import com.example.demo.Gestionnaires.UtilisateurGestionnaire;
import com.example.demo.MailingConfig.MaillingData;
import com.example.demo.Utils.EmailUtil;
import com.example.demo.Utils.PasswordUtil;

import io.jsonwebtoken.lang.Collections;

@RestController
public class UtilisateurContolleur {

    @Autowired
    private UtilisateurGestionnaire utilisateurGestionnaire;
    
    @Autowired
    private EmailUtil emailUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private PasswordUtil passwordUtil;
    
    
    
    
    
    @PostMapping("/ADMIN/ajouterUtilisateur")
    @PutMapping("/ADMIN/modifierUtilisateur")
    public ResponseEntity<?> ajouterUtilisateur(@Valid @RequestBody Utilisateur utilisateur)
    {
    	String password = passwordUtil.generateRandomPassword(10);
    	utilisateur.setPassword(passwordEncoder.encode(password));
        MaillingData maillingData = new MaillingData();
        maillingData.setEmail(utilisateur.getEmail());
        maillingData.setName("Bureau d'odre");
        maillingData.setObject("BUREAU D'ORDRE: données d’accès");
        maillingData.setDocuments(new ArrayList<>());
        maillingData.setFeedback("<p>votre compte BO est actuellement actif</p><p>Vous pouvez maintenant vous connecter à l’aide de ce mot de passe: </p><h2>"+password+"</h2>");
 
        utilisateurGestionnaire.ajouterUtilisateur(utilisateur);
        try {
			emailUtil.sendEmail(maillingData);
		} catch (MessagingException e) {
			return new ResponseEntity<>("couldn't reach user", HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    
    
    
    
    @DeleteMapping("/ADMIN/suprimerUtilisateur/{id}")
    public ResponseEntity<?> supprimerUtilisateur(@PathVariable long id)
    {
        utilisateurGestionnaire.supprimerUtilisateur(id);
        return new ResponseEntity<>("utilisateur supprimer avec succes",HttpStatus.OK);
    }

    
    
    @GetMapping("/ADMIN/utilisateurs")
    public ResponseEntity<?> recupererUtilisateurs(){
        List<Utilisateur> utilisateurs = utilisateurGestionnaire.recupererUtilisateurs();
        return new ResponseEntity<>(utilisateurs,HttpStatus.OK);
    }


}
