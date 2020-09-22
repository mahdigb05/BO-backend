package com.example.demo.Beans;

import com.sun.istack.NotNull;

import javax.persistence.*;

@MappedSuperclass

public class Personne {

    @NotNull
    @Column(nullable = false)
    private String nom;
    
    @NotNull
    @Column(nullable = false)
    private String prenom;
    
    @NotNull
    @Column(nullable = false)
    private String tel;
    
    @NotNull
    @Column(nullable = false)
    private String email;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long matricule;

    public Personne() {
    }

    public Personne(String nom, String prenom, String tel, String email, long matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMatricule() {
        return matricule;
    }

    public void setMatricule(long matricule) {
        this.matricule = matricule;
    }
}
