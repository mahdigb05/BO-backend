package com.example.demo.Gestionnaires;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Beans.Personnel;
import com.example.demo.Repositories.PersonnelDao;

@Service
public class PersonnelGestionnaire {

    @Autowired
    private PersonnelDao personnelDao;

    public List<Personnel> recupererPersonnel(){
        return (List<Personnel>) personnelDao.findAll();
    }

}
