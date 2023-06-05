/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import tn.esprit.healio.pharmacie.service.OrdonnanceService;

/**
 * FXML Controller class
 *
 * @author AMINE
 */
public class AddClientController implements Initializable {

    @FXML
    private TextField txtn;
    @FXML
    private TextField txtp;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        //OrdonnanceService os = new OrdonnanceService();
        //os.insert(new Ordonnance(txtn.getText(), txtp.get, idConsultation, idPharmacien, 0));
    }
    
}
