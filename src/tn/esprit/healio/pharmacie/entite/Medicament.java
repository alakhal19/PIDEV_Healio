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
public class Medicament {
    private int idMedicament;
    private String nomMedicament;
    private String preconisation; //enfant / adulte
    private String interaction;
    private String indication; //grecesse / conduction
    private String surdosage;
    private String effet;
    private int toxicite;

    public Medicament(int idMedicament, String nomMedicament, String preconisation, String interaction, String indication, String surdosage, String effet, int toxicite) {
        this.idMedicament = idMedicament;
        this.nomMedicament = nomMedicament;
        this.preconisation = preconisation;
        this.interaction = interaction;
        this.indication = indication;
        this.surdosage = surdosage;
        this.effet = effet;
        this.toxicite = toxicite;
    }

    public int getIdMedicament() {
        return idMedicament;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public String getPreconisation() {
        return preconisation;
    }

    public String getInteraction() {
        return interaction;
    }

    public String getIndication() {
        return indication;
    }

    public String getSurdosage() {
        return surdosage;
    }

    public String getEffet() {
        return effet;
    }

    public int isToxicite() {
        return toxicite;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public void setPreconisation(String preconisation) {
        this.preconisation = preconisation;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public void setSurdosage(String surdosage) {
        this.surdosage = surdosage;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public void setToxicite(int toxicite) {
        this.toxicite = toxicite;
    }

    @Override
    public String toString() {
        return "Medicament{" + "idMedicament=" + idMedicament + ", nomMedicament=" + nomMedicament + ", preconisation=" + preconisation + ", interaction=" + interaction + ", indication=" + indication + ", surdosage=" + surdosage + ", effet=" + effet + ", toxicite=" + toxicite + '}';
    }
    
    
    
}
