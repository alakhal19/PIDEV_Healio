/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;
import java.util.Date;
import tn.esprit.*;
import tn.esprit.healio.pharmacie.entite.Medicament;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import tn.esprit.healio.pharmacie.service.MedicamentService;
import tn.esprit.healio.pharmacie.service.OrdonnanceService;
import tn.esprit.healio.pharmacie.utilis.DataSource;
import tn.esprit.healio.pharmacie.ui.Login;
import tn.esprit.healio.pharmacie.service.MedicamentService;

/**
 *
 * @author AMINE
 */
public class PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // try insert
        Date d = new Date(2023, 4, 22);
        Ordonnance O1;
        O1 = new Ordonnance(13,2,3,1,456,0,d);
        OrdonnanceService ps=new OrdonnanceService();
        ps.insert(O1);
        
        //try update
        //Date d = new Date(121, 4, 22);
        //Ordonnance O2 = new Ordonnance(1230,2,2,2,2,2,d);
        //OrdonnanceService ps=new OrdonnanceService();
        //ps.update(O2);
        
        //try readbyid
        //OrdonnanceService ps=new OrdonnanceService();
        //Ordonnance o2= ps.readById(1204);
        //System.out.println(o2);
        
        
        //Medicament m1;
        //m1=new Medicament("123", "123", "789d", "azerty", "azert", "911", "789", 1);
        //MedicamentService ps= new MedicamentService();
       // ps.insert(m1);
    }
    
    
}
