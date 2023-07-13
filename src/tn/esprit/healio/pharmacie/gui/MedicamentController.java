/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import tn.esprit.healio.pharmacie.entite.Medicament;
import tn.esprit.healio.pharmacie.entite.Ordonnance;
import tn.esprit.healio.pharmacie.service.MedicamentService;

/**
 * FXML Controller class
 *
 * @author AMINE
 */
public class MedicamentController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tdnom;
    @FXML
    private TextField tfinter;
    @FXML
    private ComboBox<String> cbpreco;
    @FXML
    private TextField tfsurd;
    @FXML
    private TextField tfeffet;
    @FXML
    private RadioButton radiotox;
    @FXML
    private TableView<Medicament> tv;
    @FXML
    private TableColumn<Medicament, Integer> clid;
    @FXML
    private TableColumn<Medicament, String> clnom;
    @FXML
    private TableColumn<Medicament, String> clpreco;
    @FXML
    private TableColumn<Medicament, String> clinter;
    @FXML
    private TableColumn<Medicament, String> clindic;
    @FXML
    private TableColumn<Medicament, String> clsurd;
    @FXML
    private TableColumn<Medicament, String> cleffet;
    @FXML
    private TableColumn<Medicament, Integer> cltox;
    @FXML
    private TextField tfrech;
    @FXML
    private TextField tfindic;
    public Medicament selectedMedicament;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbpreco.getItems().addAll("Enfant", "Adulte");
        showMedicament ();
        
    }    
    
    public void showMedicament() {
    MedicamentService ms = new MedicamentService();
    List<Medicament> medicamentList = ms.readAll();
    ObservableList<Medicament> list = FXCollections.observableArrayList(medicamentList);
    clid.setCellValueFactory(new PropertyValueFactory<>("idMedicament"));
    clnom.setCellValueFactory(new PropertyValueFactory<>("nomMedicament"));
    clpreco.setCellValueFactory(new PropertyValueFactory<>("preconisation"));
    clinter.setCellValueFactory(new PropertyValueFactory<>("interaction"));
    clindic.setCellValueFactory(new PropertyValueFactory<>("indication"));
    clsurd.setCellValueFactory(new PropertyValueFactory<>("surdosage"));
    cleffet.setCellValueFactory(new PropertyValueFactory<>("effet"));
    cltox.setCellValueFactory(new PropertyValueFactory<>("toxicite"));
    tv.setItems(list);
}

 

    @FXML
    private void showResearch(KeyEvent event) {
        MedicamentService ms = new MedicamentService();
         List<Medicament> medicamentList = ms.readSearch(Integer.parseInt(this.tfrech.getText()));
         ObservableList<Medicament> list = FXCollections.observableArrayList(medicamentList);
        clid.setCellValueFactory(new PropertyValueFactory<>("idMedicament"));
    clnom.setCellValueFactory(new PropertyValueFactory<>("nomMedicament"));
    clpreco.setCellValueFactory(new PropertyValueFactory<>("preconisation"));
    clinter.setCellValueFactory(new PropertyValueFactory<>("interaction"));
    clindic.setCellValueFactory(new PropertyValueFactory<>("indication"));
    clsurd.setCellValueFactory(new PropertyValueFactory<>("surdosage"));
    cleffet.setCellValueFactory(new PropertyValueFactory<>("effet"));
    cltox.setCellValueFactory(new PropertyValueFactory<>("toxicite"));
    tv.setItems(list);
    }
    public void insert()
    {
        int tox=0;
        if(radiotox.isSelected())
            tox=1;
        Medicament m= new Medicament(Integer.parseInt(tfid.getText()), tdnom.getText(), cbpreco.getSelectionModel().getSelectedItem(), tfinter.getText(), tfindic.getText(), tfsurd.getText(), tfeffet.getText(), tox);
        MedicamentService ms = new MedicamentService();
        ms.insert(m);
        showMedicament();
    }

    @FXML
    private void handleAjout(ActionEvent event) {
        insert();
    }
    public void update()
    {
        int tox=0;
        if(radiotox.isSelected())
            tox=1;
        Medicament m= new Medicament(Integer.parseInt(tfid.getText()), tdnom.getText(), cbpreco.getSelectionModel().getSelectedItem(), tfinter.getText(), tfindic.getText(), tfsurd.getText(), tfeffet.getText(), tox);
        MedicamentService ms = new MedicamentService();
        ms.update(m);
        showMedicament();
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        update();
    }

    @FXML
    private void handleItem(MouseEvent event) {
        Medicament m = tv.getSelectionModel().getSelectedItem();
        this.selectedMedicament=m;
        tfid.setText(""+m.getIdMedicament());
        tdnom.setText(m.getNomMedicament());
        cbpreco.setValue(m.getPreconisation());
        tfinter.setText(m.getInteraction());
        tfindic.setText(m.getIndication());
        tfsurd.setText(m.getSurdosage());
        tfeffet.setText(m.getEffet());
        radiotox.setSelected(false);
        if(m.isToxicite()==1)
            radiotox.setSelected(true);
        
    }
    public void delete()
    {
        MedicamentService ms = new MedicamentService();
        ms.delete(Integer.parseInt(tfid.getText()));
        showMedicament();
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        delete();
    }

}
