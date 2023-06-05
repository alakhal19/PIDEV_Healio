/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import tn.esprit.healio.pharmacie.service.OrdonnanceService;

/**
 * FXML Controller class
 *
 * @author AMINE
 */
public class AddOrdonnanceController implements Initializable {

    @FXML
    private TextField tfidord;
    @FXML
    private TextField tfidcl;
    @FXML
    private TextField tfidmed;
    @FXML
    private TextField idcons;
    @FXML
    private RadioButton rdtr;
    @FXML
    private DatePicker dat;
    @FXML
    private Button btajout;
    @FXML
    private Button btmodif;
    @FXML
    private Button btsupp;
    @FXML
    private TableColumn<Ordonnance, Integer> colidord;
    @FXML
    private TableColumn<Ordonnance, Integer> colcl;
    @FXML
    private TableColumn<Ordonnance, Integer> colmed;
    @FXML
    private TableColumn<Ordonnance, Integer> colcons;
    @FXML
    private TableColumn<Ordonnance, Integer> coltr;
    @FXML
    private TableColumn<Ordonnance, Integer> coldate;
    @FXML
    private TextField tfidph;
    @FXML
    private TableColumn<Ordonnance, Integer> colph;
    @FXML
    private TableView<Ordonnance> tvOrd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showOrdonnance();
    }    
    public void showOrdonnance()
   {
       OrdonnanceService os= new OrdonnanceService();
       ObservableList<Ordonnance> list= os.readAll();
       colidord.setCellValueFactory(new PropertyValueFactory<Ordonnance , Integer>("idOrdonnance"));
       colcl.setCellValueFactory(new PropertyValueFactory<Ordonnance , Integer>("idClient"));
       colmed.setCellValueFactory(new PropertyValueFactory<Ordonnance , Integer>("idMedecin"));
       colcons.setCellValueFactory(new PropertyValueFactory<Ordonnance , Integer>("idConsultation"));
       colph.setCellValueFactory(new PropertyValueFactory<Ordonnance , Integer>("idPharm"));
       coltr.setCellValueFactory(new PropertyValueFactory<Ordonnance , Integer>("traite"));
       coldate.setCellValueFactory(new PropertyValueFactory<Ordonnance , Integer>("dateTraitement"));
       tvOrd.setItems(list);
   }
    public void insert()
    {
        int traitee=0;
        if (rdtr.isSelected())
            traitee=1;
        Date d = new Date(2023, 4, 22);
        Ordonnance o=new Ordonnance(Integer.parseInt(tfidord.getText()), Integer.parseInt(tfidcl.getText()), Integer.parseInt(tfidmed.getText()), Integer.parseInt(idcons.getText()), Integer.parseInt(tfidph.getText()), traitee, d);
        OrdonnanceService os= new OrdonnanceService();
        os.insert(o);
        showOrdonnance();
    }

    @FXML
    private void handleAjout(ActionEvent event) {
        insert();
    }
    public void update()
    {
        int traitee=0;
        if (rdtr.isSelected())
            traitee=1;
        Date d = new Date(2023, 4, 22);
        Ordonnance o=new Ordonnance(Integer.parseInt(tfidord.getText()), Integer.parseInt(tfidcl.getText()), Integer.parseInt(tfidmed.getText()), Integer.parseInt(idcons.getText()), Integer.parseInt(tfidph.getText()), traitee, d);
        OrdonnanceService os= new OrdonnanceService();
        os.update(o);
        showOrdonnance();
    }

    @FXML
    private void handleModify(ActionEvent event) {
        update();
    }
    public void delete()
    {
        int id=Integer.parseInt(tfidord.getText());
        OrdonnanceService os= new OrdonnanceService();
        os.delete(id);
        showOrdonnance();
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        delete();
    }

    @FXML
    private void handleItem(MouseEvent event) {
        Ordonnance Or =  tvOrd.getSelectionModel().getSelectedItem();
        tfidord.setText(""+Or.getIdOrdonnance());
        tfidcl.setText(""+Or.getIdClient());
        tfidmed.setText(""+Or.getIdMedecin());
        idcons.setText(""+Or.getIdConsultation());
        tfidph.setText(""+Or.getIdPharmacien());
        if(Or.isTraitee()==1)
            rdtr.setSelected(true);
        else
            rdtr.setSelected(false);
    }
    
}
