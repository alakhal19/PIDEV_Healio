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
public class Client {

    private String idClient;
    private String nom;
    private String prenom;
    private String email;
    private long telephone;
    private String adresse;
    private String motDePasse;
    private int roleId;

    public Client() {

    }

    public Client(String i, String n, String p, String e, long t, String ad, String mp, int ri) {
        this.idClient = i;
        this.nom = n;
        this.prenom = p;
        this.email = e;
        this.telephone = t;
        this.adresse = ad;
        this.motDePasse = mp;
        this.roleId = ri;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public long getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse + ", motDePasse=" + motDePasse + ", roleId=" + roleId + '}';
    }
    
    

}
