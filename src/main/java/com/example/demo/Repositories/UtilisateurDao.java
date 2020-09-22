package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.Utilisateur;

@Repository

public interface UtilisateurDao extends CrudRepository<Utilisateur,Long> {
    Utilisateur findByEmail(String email);
    Utilisateur findByTel(String tel);
}
