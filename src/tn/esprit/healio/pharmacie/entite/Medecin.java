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
    private int idMedecin;
    private String specialite;
    private String telephoneMedecin;
    private String emailMedecin;
    private String adresseCabinet;

    public Medecin() {
        super();
    }
    
    public Medecin(int i, String n, String p, String e, String t, String ad, String mp,
            int ri,int im, String sp, String tm, String em,String ac) {
        super(i,n,p,e,t,ad,mp,ri);
        this.idMedecin=im;
        this.specialite=sp;
        this.telephoneMedecin=tm;
        this.emailMedecin=em;
        this.adresseCabinet=ac;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getTelephoneMedecin() {
        return telephoneMedecin;
    }

    public String getEmailMedecin() {
        return emailMedecin;
    }

    public String getAdresseCabinet() {
        return adresseCabinet;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setTelephoneMedecin(String telephoneMedecin) {
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
