package com.example.demo.Gestionnaires;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Beans.Courrier;
import com.example.demo.Beans.Document;
import com.example.demo.Beans.TYPE_COURRIER;
import com.example.demo.Repositories.DocumentDao;

@Service
public class DocumentGestionnaire {
	
	@Autowired
	private CourrierGestionnaire courrierGestionnaire;
	
	@Autowired
	private DocumentDao documentDao;
	
    public static String uploadDir = System.getProperty("user.dir")+"/uploadedDocs";
	
	public Document ajouterDocument(MultipartFile document,Long idCourrier, TYPE_COURRIER type) {
		
		Courrier courrier = courrierGestionnaire.recupererCourrier(idCourrier, type);
		
		Document doc = new Document();
		
		File file = new File(uploadDir, document.getOriginalFilename());
    	
		int i = 0;
    	while (file.exists()) {
			i++;
			file = new File(uploadDir, document.getOriginalFilename()+"-"+String.valueOf(i));
		}
		
		Path chemainDocument = Paths.get(file.getAbsolutePath());
    	try {
			Files.write(chemainDocument, document.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	doc.setNomDocument(document.getOriginalFilename());
    	doc.setCheminDocument(file.getAbsolutePath());
    	doc.setTypeCourrierAccosiee(type);
    	doc.setCourrier(courrier);
    	
    	return documentDao.save(doc);
		
	}
	
}
