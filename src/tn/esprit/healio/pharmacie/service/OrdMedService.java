/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.service;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.healio.pharmacie.entite.Medicament;
import tn.esprit.healio.pharmacie.entite.OrdMed;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import tn.esprit.healio.pharmacie.utilis.DataSource;

/**
 *
 * @author AMINE
 */
public class OrdMedService implements Iservice<OrdMed>{
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrdMedService()
    {
        connexion = DataSource.getInstance().getCnx();
    }
    @Override
    public void insert(OrdMed t) {
        String requete = "INSERT INTO `ordmed`(`idOrdonnance`, `idMedicament`, `frequence`, `nouriture`, `quantite`) VALUES ('"+t.getOrdonnance().getIdOrdonnance()+"','"+t.getMedicament().getIdMedicament()+"','"+t.getFrequence()+"','"+t.getNouriture()+"','"+t.getQuantite()+"')";
        try {
            ste = connexion.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Values inserted successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<OrdMed> readAll() {
        String requete="select * from ordmed";
        ObservableList<OrdMed> list=FXCollections.observableArrayList();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                OrdonnanceService OrdS= new OrdonnanceService();
                MedicamentService MedS = new MedicamentService();
                Ordonnance Ord = OrdS.readById(rs.getInt("idOrdonnance"));
                Medicament Med = MedS.readById(rs.getInt("idMedicament"));
                OrdMed p;
                p = new OrdMed(Ord, Med, rs.getString("frequence"), rs.getString("nouriture"), rs.getString("quantite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    @Override
    public OrdMed readById(int id) {
        String requete="SELECT * FROM `ordmed` WHERE idOrdonnance ='"+id+"'";
        OrdMed p = null;
        Ordonnance o;
        OrdonnanceService os = new OrdonnanceService();
        Medicament m=null;
        MedicamentService ms= new MedicamentService();
        try {
            Statement ste=connexion.createStatement();
            ResultSet rs=ste.executeQuery(requete);
            if (rs.next()) {
                o = os.readById(id);
                m = ms.readById(rs.getInt("idMedicament"));
                 p = new OrdMed(o, m, rs.getString("frequence"), rs.getString("nouriture"), rs.getString("quantite"));
            } else
                System.out.println("No record found with ID: " + id);
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    
    
    
    public ObservableList<OrdMed> readAllItems(int id) {
        String requete="SELECT * FROM `ordmed` WHERE idOrdonnance ='"+id+"'";
        ObservableList<OrdMed> list=FXCollections.observableArrayList();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                OrdonnanceService OrdS= new OrdonnanceService();
                MedicamentService MedS = new MedicamentService();
                Ordonnance Ord = OrdS.readById(rs.getInt("idOrdonnance"));
                Medicament Med = MedS.readById(rs.getInt("idMedicament"));
                OrdMed p;
                p = new OrdMed(Ord, Med, rs.getString("frequence"), rs.getString("nouriture"), rs.getString("quantite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   /* public List<OrdMed> readAllItems(int id) {
    String requete = "SELECT * FROM `ordmed` WHERE idOrdonnance = ?";
    List<OrdMed> list = FXCollections.observableArrayList();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        
        while (rs.next()) {
            OrdonnanceService ordS = new OrdonnanceService();
            MedicamentService medS = new MedicamentService();
            Ordonnance ord = ordS.readById(rs.getInt("idOrdonnance"));
            Medicament med = medS.readById(rs.getInt("idMedicament"));
            
            OrdMed p = new OrdMed(
                ord,
                med,
                rs.getString("frequence"),
                rs.getString("nouriture"),
                rs.getString("quantite")
            );
            list.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Reading problem");
    } finally {
        // Close the PreparedStatement and ResultSet
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                // Handle the exception
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                // Handle the exception
            }
        }
    }
    
    return list;
}*/
    

    @Override
    public void delete(int id) {
        String requete="DELETE FROM `ordmed` WHERE idOrdonnance= '"+id+"'";
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
    public void update(OrdMed t) {
        String requete ="UPDATE `ordmed` SET `idOrdonnance`='"+t.getOrdonnance().getIdOrdonnance()+"',`idMedicament`='"+t.getMedicament().getIdMedicament()+"',`frequence`='"+t.getFrequence()+"',`nouriture`='"+t.getNouriture()+"',`quantite`='"+t.getQuantite()+"' WHERE `idOrdonnance`='"+t.getOrdonnance().getIdOrdonnance()+"'";
        try {
            ste=connexion.createStatement();
            int affected;
            affected = ste.executeUpdate(requete);
            if (affected > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No record found with ID: " + t.getOrdonnance().getIdOrdonnance());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
