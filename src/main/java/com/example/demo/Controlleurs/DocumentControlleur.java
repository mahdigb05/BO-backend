package com.example.demo.Controlleurs;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Beans.Document;
import com.example.demo.Beans.TYPE_COURRIER;
import com.example.demo.Gestionnaires.DocumentGestionnaire;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class DocumentControlleur {
	
	@Autowired
	private DocumentGestionnaire documentGestionnaire;
	
	@PostMapping("/ADMIN/ajouterDocument")
	public ResponseEntity<?> ajouterDocument(@RequestBody HashMap<String,Object> map)
	{
		
		Long idCourrier = (Long)map.get("numeroCourrier");
		map.remove("numeroCourrier");
		
		TYPE_COURRIER type = (TYPE_COURRIER)map.get("typeCourrier");
		map.remove("typeCourrier");
		
		ObjectMapper objectMapper = new ObjectMapper();
        MultipartFile document = objectMapper.convertValue(map,MultipartFile.class);
	
        Document doc = documentGestionnaire.ajouterDocument(document, idCourrier, type);
        
        return new ResponseEntity<>(doc,HttpStatus.OK);
	}

}
