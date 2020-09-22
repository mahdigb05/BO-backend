package com.example.demo.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numeroDocument;
	
	@NonNull
	@Column(nullable = false)
	private String nomDocument;

	@NonNull
	@Column(nullable = false)
	private TYPE_COURRIER typeCourrierAccosiee;
	
	@Column(nullable = false)
	private String cheminDocument;
	
	@ManyToOne
	private Courrier courrier;
	


	


	public Document(Long numeroDocument, String nomDocument, TYPE_COURRIER typeCourrierAccosiee, Courrier courrier) {
		super();
		this.numeroDocument = numeroDocument;
		this.nomDocument = nomDocument;
		this.typeCourrierAccosiee = typeCourrierAccosiee;
		this.courrier = courrier;
	}


	public Document() {
		super();
	}

	

	public String getCheminDocument() {
		return cheminDocument;
	}


	public void setCheminDocument(String cheminDocument) {
		this.cheminDocument = cheminDocument;
	}


	public Long getNumeroDocument() {
		return numeroDocument;
	}


	public void setNumeroDocument(Long numeroDocument) {
		this.numeroDocument = numeroDocument;
	}


	public String getNomDocument() {
		return nomDocument;
	}


	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}


	public TYPE_COURRIER getTypeCourrierAccosiee() {
		return typeCourrierAccosiee;
	}


	public void setTypeCourrierAccosiee(TYPE_COURRIER typeCourrierAccosiee) {
		this.typeCourrierAccosiee = typeCourrierAccosiee;
	}


	public Courrier getCourrier() {
		return courrier;
	}


	public void setCourrier(Courrier courrier) {
		this.courrier = courrier;
	}


	
	
	
}
