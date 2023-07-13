/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.entite;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author AMINE
 */
public class Ordonnance {
    private int idOrdonnance;
    private int idClient;
    private int idMedecin;
    private int idConsultation;
    private int idPharmacien;
    private int traitee;
    private LocalDate dateTraitement;

    public Ordonnance() {
    }

    public Ordonnance(int idOrdonnance, int idClient, int idMedecin, int idConsultation, int idPharmacien, int traitee, LocalDate dateTraitement) {
        this.idOrdonnance=idOrdonnance;
        this.idClient = idClient;
        this.idMedecin = idMedecin;
        this.idConsultation = idConsultation;
        this.idPharmacien = idPharmacien;
        this.traitee = traitee;
        this.dateTraitement = dateTraitement;
    }
    public Ordonnance(int idOrdonnance,int idClient, int idMedecin, int idConsultation, int idPharmacien, int traitee) {
        this.idOrdonnance=idOrdonnance;
        this.idClient = idClient;
        this.idMedecin = idMedecin;
        this.idConsultation = idConsultation;
        this.idPharmacien = idPharmacien;
        this.traitee = traitee;
    }

    public int getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(int idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    @Override
    public String toString() {
        return "Ordonnance{" + "idOrdonnance=" + idOrdonnance + ", idClient=" + idClient + ", idMedecin=" + idMedecin + ", idConsultation=" + idConsultation + ", idPharmacien=" + idPharmacien + ", traitee=" + traitee + ", dateTraitement=" + dateTraitement + '}';
    }

    

    
    

    

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public void setIdConsultation(int idConsultation) {
        this.idConsultation = idConsultation;
    }

    public void setIdPharmacien(int idPharmacien) {
        this.idPharmacien = idPharmacien;
    }

    public void setTraitee(int traitee) {
        this.traitee = traitee;
    }

    public void setDateTraitement(LocalDate dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public int getIdPharmacien() {
        return idPharmacien;
    }

    public int isTraitee() {
        return traitee;
    }

    public LocalDate getDateTraitement() {
        return dateTraitement;
    }
    
    
    
}
