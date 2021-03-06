package com.example.demo.Beans;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CourrierIntern extends Courrier{


    @NotNull
    @Column(nullable = false)
    private Date dateEnvoi;
    
    @NotNull
    @Column(nullable = false)
    private Date dateReception;
    
    @OneToOne
    @NotNull
    @JoinColumn(nullable = false)
    private Personnel recepteur;
    
    @OneToOne
    @NotNull
    @JoinColumn(nullable = false)
    private Personnel emetteur;

    public CourrierIntern() {}


    public CourrierIntern(long numeroCourrier, String methodeEnvoi, String objet, String natureCourrier, TYPE_COURRIER type, Date dateEnvoi, Date dateReception, Personnel recepteur, Personnel emetteur) {
        super(numeroCourrier, methodeEnvoi, objet, natureCourrier, type);
        this.dateEnvoi = dateEnvoi;
        this.dateReception = dateReception;
        this.recepteur = recepteur;
        this.emetteur = emetteur;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Personnel getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Personnel recepteur) {
        this.recepteur = recepteur;
    }

    public Personnel getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Personnel emetteur) {
        this.emetteur = emetteur;
    }
}
