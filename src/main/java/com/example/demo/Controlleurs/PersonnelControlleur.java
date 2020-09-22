package com.example.demo.Controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Gestionnaires.PersonnelGestionnaire;

@RestController
public class PersonnelControlleur {

    @Autowired
    private PersonnelGestionnaire personnelGestionnaire;

    @GetMapping("/personnel")
    public ResponseEntity<?> recupererPersonnel(){
        return new ResponseEntity<>(personnelGestionnaire.recupererPersonnel(), HttpStatus.OK);
    }

}
