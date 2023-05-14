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
public class Medecin extends Client {
    private String idMedecin;
    private String specialite;
    private long telephoneMedecin;
    private String emailMedecin;
    private String adresseCabinet;

    public Medecin() {
        super();
    }
    
    public Medecin(String i, String n, String p, String e, long t, String ad, String mp,
            int ri,String im, String sp, long tm, String em,String ac) {
        super(i,n,p,e,t,ad,mp,ri);
        this.idMedecin=im;
        this.specialite=sp;
        this.telephoneMedecin=tm;
        this.emailMedecin=em;
        this.adresseCabinet=ac;
    }

    public String getIdMedecin() {
        return idMedecin;
    }

    public String getSpecialite() {
        return specialite;
    }

    public long getTelephoneMedecin() {
        return telephoneMedecin;
    }

    public String getEmailMedecin() {
        return emailMedecin;
    }

    public String getAdresseCabinet() {
        return adresseCabinet;
    }

    public void setIdMedecin(String idMedecin) {
        this.idMedecin = idMedecin;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setTelephoneMedecin(long telephoneMedecin) {
        this.telephoneMedecin = telephoneMedecin;
    }

    public void setEmailMedecin(String emailMedecin) {
        this.emailMedecin = emailMedecin;
    }

    public void setAdresseCabinet(String adresseCabinet) {
        this.adresseCabinet = adresseCabinet;
    }

    @Override
    public String toString() {
        return super.toString()+"Medecin{" + "idMedecin=" + idMedecin + ", specialite=" + specialite + ", telephoneMedecin=" + telephoneMedecin + ", emailMedecin=" + emailMedecin + ", adresseCabinet=" + adresseCabinet +'}';
    }
    
}
