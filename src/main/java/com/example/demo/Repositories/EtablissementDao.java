package com.example.demo.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.Etablissement;

@Repository
public interface EtablissementDao extends CrudRepository<Etablissement, Long> {

}
