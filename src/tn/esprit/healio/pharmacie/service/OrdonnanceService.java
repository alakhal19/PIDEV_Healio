/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.service;

import java.util.List;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.healio.pharmacie.utilis.DataSource;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author AMINE
 */
public class OrdonnanceService implements Iservice<Ordonnance> {

    private Connection connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     *
     */
    public OrdonnanceService() {
        connexion = DataSource.getInstance().getCnx();

    }
    @Override
    public void insert(Ordonnance t) {
        java.sql.Timestamp dat = new java.sql.Timestamp(t.getDateTraitement().getTime());
         String requete = "INSERT INTO `ordonnance`(`idOrdonnance`, `idClient`, `idMedecin`, `idConsultation`, `idPharm`, `traite`, `dateTraitement`) VALUES ('" + t.getIdOrdonnance()+ "','"+ t.getIdClient()+ "','" +t.getIdMedecin() + "','" + t.getIdConsultation()+ "','" +t.getIdPharmacien()+"','"+t.isTraitee()+"','"+dat+"')";

        try {
            ste = connexion.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Values inserted successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<Ordonnance> readAll() {
        String requete="select * from ordonnance";
        ObservableList<Ordonnance> list=FXCollections.observableArrayList();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                Ordonnance p;
                p = new Ordonnance(rs.getInt("idOrdonnance"),rs.getInt("idClient"), rs.getInt("idMedecin"), rs.getInt("idConsultation"), rs.getInt("idPharm"),rs.getInt("traite"),rs.getDate("dateTraitement"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Ordonnance readById(int id) {
        String requete="SELECT * FROM `ordonnance` WHERE idOrdonnance ='"+id+"'";
        Ordonnance p = null;
        try {
            Statement ste=connexion.createStatement();
            ResultSet rs=ste.executeQuery(requete);
            if (rs.next()) {
                 p = new Ordonnance(rs.getInt("idOrdonnance"),rs.getInt("idClient"), rs.getInt("idMedecin"), rs.getInt("idConsultation"), rs.getInt("idPharm"),rs.getInt("traite"),rs.getDate("dateTraitement"));
            } else
                System.out.println("No record found with ID: " + id);
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        String requete="DELETE FROM `ordonnance` WHERE idOrdonnance= '"+id+"'";
        try {
            ste=connexion.createStatement();
            int affected;
            affected = ste.executeUpdate(requete);
            if (affected > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("No record found with ID: " + id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Ordonnance t) {
        java.sql.Timestamp dat = new java.sql.Timestamp(t.getDateTraitement().getTime());
        String requete ="UPDATE `ordonnance` SET `idClient`='"+t.getIdClient()+"',`idMedecin`='"+t.getIdMedecin()+"',`idConsultation`='"+t.getIdConsultation()+"',`idPharm`='"+t.getIdPharmacien()+"',`traite`='"+t.isTraitee()+"',`dateTraitement`='"+dat+"' WHERE `idOrdonnance`='"+t.getIdOrdonnance()+"'";
        try {
            ste=connexion.createStatement();
            int affected;
            affected = ste.executeUpdate(requete);
            if (affected > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No record found with ID: " + t.getIdOrdonnance());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
