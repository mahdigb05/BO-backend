package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Gestionnaires.DocumentGestionnaire;

@SpringBootApplication
public class BureauOrdreApplication {

    public static void main(String[] args) {
    	new File(DocumentGestionnaire.uploadDir).mkdir();
        SpringApplication.run(BureauOrdreApplication.class, args);
    }

}
