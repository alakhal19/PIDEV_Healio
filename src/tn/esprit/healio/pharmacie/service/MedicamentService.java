/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.service;
import java.util.List;
import tn.esprit.healio.pharmacie.entite.Medicament;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import tn.esprit.healio.pharmacie.utilis.DataSource;
/**
 *
 * @author AMINE
 */
public class MedicamentService  implements Iservice<Medicament> {
    
    private Connection connexion;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     *
     */
    public MedicamentService() {
        connexion = DataSource.getInstance().getCnx();

    }
    public void insert(Medicament t) {
         String requete = "INSERT INTO `medicament`(`idMedicament`, `nomMedicament`, `preconisation`, `interaction`, `indication`, `surdosage`, `effet`, `toxicite`) VALUES ('" + t.getIdMedicament()+ "','"+ t.getNomMedicament()+ "','" +t.getPreconisation()+ "','" + t.getInteraction()+ "','" +t.getIndication()+"','"+t.getSurdosage()+"','"+t.getEffet()+"','"+t.isToxicite()+"')";

        try {
            ste = connexion.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Medicament> readAll() {
        String requete="select * from medicament";
        List<Medicament> list=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next()){
                Medicament p;
                p = new Medicament(rs.getInt("idMedicament"), rs.getString("nomMedicament"), rs.getString("preconisation"), rs.getString("interaction"), rs.getString("indication"), rs.getString("surdosage"), rs.getString("effet"), rs.getInt("toxicite"));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Integer> readAllId()
    {
        String requete = "select idMedicament from medicament";
        List<Integer> list=new ArrayList<>();
        try {
            ste=connexion.createStatement();
            rs=ste.executeQuery(requete);
            while(rs.next())
            {
                list.add(rs.getInt("idMedicament"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public Medicament readById(int id) {
        String requete="SELECT * FROM `medicament` WHERE idMedicament ='"+id+"'";
        Medicament m=null;
        try {
            Statement ste=connexion.createStatement();
            ResultSet rs=ste.executeQuery(requete);
            if (rs.next()) {
                m= new Medicament(rs.getInt("idMedicament"), rs.getString("nomMedicament"), rs.getString("preconisation"), rs.getString("interaction"), rs.getString("indication"), rs.getString("surdosage"), rs.getString("effet"),rs.getInt("toxicite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public void delete(int id) {
        String requete="DELETE FROM `medicament` WHERE idMedicament= '"+id+"'";
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
    public void update(Medicament t) {
        String requete = "UPDATE `medicament` SET `nomMedicament`='"+t.getNomMedicament()+"',`preconisation`='"+t.getPreconisation()+"',`interaction`='"+t.getInteraction()+"',`indication`='"+t.getIndication()+"',`surdosage`='"+t.getSurdosage()+"',`effet`='"+t.getEffet()+"',`toxicite`='"+t.isToxicite()+"' WHERE `idMedicament`="+t.getIdMedicament();
        try {
            ste=connexion.createStatement();
            int affected;
            affected = ste.executeUpdate(requete);
            if (affected > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No record found with ID: " + t.getIdMedicament());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Medicament> readSearch(int id) {
    String query = "SELECT * FROM medicament WHERE idMedicament LIKE '%" + id + "%'";
    List<Medicament> searchResults = new ArrayList<>();

    try {
        Statement statement = connexion.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int medicamentId = resultSet.getInt("idMedicament");
            String medicamentName = resultSet.getString("nomMedicament");
            String preconisation = resultSet.getString("preconisation");            
            String interaction = resultSet.getString("interaction");
            String indication = resultSet.getString("indication");
            String surdosage = resultSet.getString("surdosage");
            String effet = resultSet.getString("effet");
            int toxicite = resultSet.getInt("toxicite");

            Medicament medicament = new Medicament(medicamentId, medicamentName, preconisation, interaction,indication,
                    surdosage, effet, toxicite);
            searchResults.add(medicament);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return searchResults;
}
    
}