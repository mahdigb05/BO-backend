package com.example.demo.Beans;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Departement {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroDepartement;
    
    @Column(nullable = false)
    @NotNull
    private String nomDepartement;

    public Departement() {
    }

    public Departement(long numeroDepartement, String nomDepartement) {
        this.numeroDepartement = numeroDepartement;
        this.nomDepartement = nomDepartement;
    }

    public long getNumeroDepartement() {
        return numeroDepartement;
    }

    public void setNumeroDepartement(long numeroDepartement) {
        this.numeroDepartement = numeroDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
}
