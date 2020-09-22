package com.example.demo.Beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Courrier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroCourrier;
    
    @NotNull
    @Column(nullable = false)
    private String methodeEnvoi;
    
    @NotNull
    @Column(nullable = false)
    private String objet;
    
    @NotNull
    @Column(nullable = false)
    private String natureCourrier;
    
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TYPE_COURRIER type;
    
    @OneToMany(targetEntity = Document.class,mappedBy = "courrier", cascade = CascadeType.ALL)
    private List<Document> documents;


    public Courrier() {
    }

    public Courrier(long numeroCourrier, String methodeEnvoi, String objet, String natureCourrier, TYPE_COURRIER type) {
        this.numeroCourrier = numeroCourrier;
        this.methodeEnvoi = methodeEnvoi;
        this.objet = objet;
        this.natureCourrier = natureCourrier;
        this.type = type;
    }

    public TYPE_COURRIER getType() {
        return type;
    }

    public void setType(TYPE_COURRIER type) {
        this.type = type;
    }

    public long getNumeroCourrier() {
        return numeroCourrier;
    }

    public void setNumeroCourrier(long numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
    }

    public String getMethodeEnvoi() {
        return methodeEnvoi;
    }

    public void setMethodeEnvoi(String methodeEnvoi) {
        this.methodeEnvoi = methodeEnvoi;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getNatureCourrier() {
        return natureCourrier;
    }

    public void setNatureCourrier(String natureCourrier) {
        this.natureCourrier = natureCourrier;
    }

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

    
}
