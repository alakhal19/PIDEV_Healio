/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.entite;

/**
 *
 * @author AMINE
 */
public class OrdMed {
    private Ordonnance ordonnance;
    private Medicament medicament;
    private String frequence;
    private String nouriture;
    private String quantite;

        public OrdMed() {

    }

    @Override
    public String toString() {
        return "Medicament : " +this.medicament.getIdMedicament()+ " : frequence=" + frequence + ", nouriture=" + nouriture + ", quantite=" + quantite;
    }

    public OrdMed(Ordonnance ordonnance, Medicament medicament, String frequence, String nouriture, String quantite) {
        this.ordonnance = ordonnance;
        this.medicament = medicament;
        this.frequence = frequence;
        this.nouriture = nouriture;
        this.quantite = quantite;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public String getFrequence() {
        return frequence;
    }

    public String getNouriture() {
        return nouriture;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public void setNouriture(String nouriture) {
        this.nouriture = nouriture;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
    
    public int getmedicamentId()
    {
        return(this.getMedicament().getIdMedicament());
    }
    public void setmedicamentId(int x)
    {
        this.getMedicament().setIdMedicament(x);
    }
}
