package com.example.demo.Gestionnaires;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Beans.Utilisateur;
import com.example.demo.Exceptions.EmailOrTelAlreadyExistException;
import com.example.demo.Repositories.UtilisateurDao;

@Service
public class UtilisateurGestionnaire {

    @Autowired
    private UtilisateurDao utilisateurDao;

    public void ajouterUtilisateur(Utilisateur utilisateur){
        Utilisateur userWithSameEmail = utilisateurDao.findByEmail(utilisateur.getEmail());
        Utilisateur userWithSameTel = utilisateurDao.findByTel(utilisateur.getTel());

        if(userWithSameEmail == null && userWithSameTel == null) {
            utilisateurDao.save(utilisateur);
        }
        else if(userWithSameEmail != null && userWithSameTel != null)
            throw new EmailOrTelAlreadyExistException("email,tel");
        else if (userWithSameEmail != null)
            throw new EmailOrTelAlreadyExistException("email");
        else
            throw new EmailOrTelAlreadyExistException("tel");
    }

    public void supprimerUtilisateur(long matricule){
        utilisateurDao.deleteById(matricule);
    }

    public Utilisateur recupererUtilisateur(long matricule){
        Optional<Utilisateur> user = utilisateurDao.findById(matricule);

        return user.orElse(null);
    }

    public List<Utilisateur> recupererUtilisateurs(){
        return (List<Utilisateur>) utilisateurDao.findAll();
    }

    public Boolean isExist(long matricule){
        return utilisateurDao.existsById(matricule);
    }
}
