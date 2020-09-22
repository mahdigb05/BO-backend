package com.example.demo.Gestionnaires;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Beans.Courrier;
import com.example.demo.Beans.CourrierArrive;
import com.example.demo.Beans.CourrierDepart;
import com.example.demo.Beans.CourrierIntern;
import com.example.demo.Beans.Document;
import com.example.demo.Beans.TYPE_COURRIER;
import com.example.demo.Controlleurs.CourrierControlleur;
import com.example.demo.Repositories.CourrierArriveDao;
import com.example.demo.Repositories.CourrierDepartDao;
import com.example.demo.Repositories.CourrierInternDao;


@Service
public class CourrierGestionnaire {

    @Autowired
    private CourrierDepartDao courrierDepartDao;
    @Autowired
    private CourrierArriveDao courrierArriveDao;
    @Autowired
    private CourrierInternDao courrierInternDao;
    
    
    
    public <T extends Courrier> void ajouterCourrier(T t){
        
        if(t.getType() == TYPE_COURRIER.ARRIVEE){
            courrierArriveDao.save((CourrierArrive) t);
        }
        else if(t.getType() == TYPE_COURRIER.DEPART){
            courrierDepartDao.save((CourrierDepart) t);
        }
        else
            courrierInternDao.save((CourrierIntern) t);
        
        
    }

    public <T extends Courrier> void supprimerCourrier(T courrier){

        if(courrier.getType() == TYPE_COURRIER.ARRIVEE){
            courrierArriveDao.delete((CourrierArrive) courrier);
        }
        else if(courrier.getType() == TYPE_COURRIER.DEPART){
            courrierDepartDao.delete((CourrierDepart) courrier);
        }
        else
            courrierInternDao.delete((CourrierIntern) courrier);
    }

    @SuppressWarnings("unchecked")
	public <T extends Courrier> T recupererCourrier(Long numeroCourrier, TYPE_COURRIER type){
        
    	
    	switch(type) {
    		case INTERN:
    			return (T) courrierInternDao.findById(numeroCourrier).orElse(null);
    		case ARRIVEE:
    			return (T) courrierArriveDao.findById(numeroCourrier).orElse(null);
    		case DEPART:
    			return (T) courrierDepartDao.findById(numeroCourrier).orElse(null);
    		default:
    			return null;
    	}
    	
    }

    public List<Courrier> recupererCourriers(){

        List<CourrierArrive> courriersArrive = (List<CourrierArrive>) courrierArriveDao.findAll();
        List<CourrierDepart> courriersDepart = (List<CourrierDepart>) courrierDepartDao.findAll();
        List<CourrierIntern> courriersIntern = (List<CourrierIntern>) courrierInternDao.findAll();

        List<Courrier> courriers = new ArrayList<>();

        courriers.addAll(courriersArrive);
        courriers.addAll(courriersDepart);
        courriers.addAll(courriersIntern);

        return courriers;
    }

    public <T> Boolean isExist(Long numeroCourrier, Function<Long,Boolean> function){
        return function.apply(numeroCourrier);
    }
}
