package com.example.demo.Beans;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Personnel extends Personne{

    @OneToOne
    @NotNull
    @JoinColumn(nullable = false)
    private Departement departement;


    public Personnel(String nom, String prenom, String tel, String email, long matricule, Departement departement) {
        super(nom, prenom, tel, email, matricule);
        this.departement = departement;
    }

    public Personnel() {
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
