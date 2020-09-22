package com.example.demo.Controlleurs;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Beans.Courrier;
import com.example.demo.Beans.CourrierArrive;
import com.example.demo.Beans.CourrierDepart;
import com.example.demo.Beans.CourrierIntern;
import com.example.demo.Beans.Etablissement;
import com.example.demo.Beans.Personnel;
import com.example.demo.Gestionnaires.CourrierGestionnaire;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CourrierControlleur {

    @Autowired
    private CourrierGestionnaire courrierGestionnaire;
    @Autowired
    private EntityManager entityManager;

    @PostMapping("/RBO/ajouterCourrierDepart")
    @PutMapping("/RBO/ajouterCourrierDepart")
    public  ResponseEntity<?> ajouterCourrierDepart(@RequestBody Map<String,Object> map){

        Long idEmetteur = new Long((Integer)map.get("idEmetteur"));
        Long idRecepteur = new Long((Integer)map.get("idRecepteur"));

        Personnel emetteur = entityManager.getReference(Personnel.class,idEmetteur);
        Etablissement recepteur = entityManager.getReference(Etablissement.class,idRecepteur);

        map.remove("idRecepteur");
        map.remove("idEmetteur");
        

        ObjectMapper objectMapper = new ObjectMapper();
        CourrierDepart courrier = objectMapper.convertValue(map,CourrierDepart.class);

        courrier.setEmetteur(emetteur);
        courrier.setRecepteur(recepteur);

        courrierGestionnaire.ajouterCourrier(courrier);
        return new ResponseEntity<>("courrier ajoute avec succes", HttpStatus.OK);
    }

    @PostMapping("/RBO/ajouterCourrierIntern")
    @PutMapping("/RBO/ajouterCourrierIntern")
    public  ResponseEntity<?> ajouterCourrierIntern(@RequestBody Map<String,Object> map){

        Long idEmetteur = new Long((Integer)map.get("idEmetteur"));
        Long idRecepteur = new Long((Integer)map.get("idRecepteur"));

        Personnel emetteur = entityManager.getReference(Personnel.class,idEmetteur);
        Personnel recepteur = entityManager.getReference(Personnel.class,idRecepteur);

        map.remove("idRecepteur");
        map.remove("idEmetteur");
        

        ObjectMapper objectMapper = new ObjectMapper();
        CourrierIntern courrier = objectMapper.convertValue(map,CourrierIntern.class);

        courrier.setEmetteur(emetteur);
        courrier.setRecepteur(recepteur);

        courrierGestionnaire.ajouterCourrier(courrier);
        return new ResponseEntity<>("courrier ajoute avec succes", HttpStatus.OK);
    }

    @PostMapping("/RBO/ajouterCourrierArrive")
    @PutMapping("/RBO/ajouterCourrierArrive")
    public   ResponseEntity<?> ajouterCourrierArrive(@RequestBody Map<String,Object> map){

        Long idEmetteur = new Long((Integer)map.get("idEmetteur"));
        Long idRecepteur = new Long((Integer)map.get("idRecepteur"));

        Etablissement emetteur = entityManager.getReference(Etablissement.class,idEmetteur);
        Personnel recepteur = entityManager.getReference(Personnel.class,idRecepteur);

        map.remove("idRecepteur");
        map.remove("idEmetteur");
        

        ObjectMapper objectMapper = new ObjectMapper();
        CourrierArrive courrier = objectMapper.convertValue(map,CourrierArrive.class);

        courrier.setEmetteur(emetteur);
        courrier.setRecepteur(recepteur);

        courrierGestionnaire.ajouterCourrier(courrier);
        return new ResponseEntity<>("courrier ajoute avec succes", HttpStatus.OK);
    }

    @GetMapping("/courriers")
    public ResponseEntity<?> recupererCourriers(){
        List<Courrier> courriers = courrierGestionnaire.recupererCourriers();
        return new ResponseEntity<>(courriers, HttpStatus.OK);
    }

    @PostMapping("/RBO/supprimerCourrier")
    public <T extends Courrier> ResponseEntity<?> supprimerCourrier(@RequestBody T courrier){
        courrierGestionnaire.supprimerCourrier(courrier);
        return new ResponseEntity<>("courrier supprimer avec succes",HttpStatus.OK);
    }
}
